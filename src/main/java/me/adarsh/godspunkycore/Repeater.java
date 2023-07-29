package me.adarsh.godspunkycore;

import me.adarsh.godspunkycore.features.entity.StaticDragonManager;
import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import me.adarsh.godspunkycore.features.item.armor.TickingSet;
import me.adarsh.godspunkycore.features.potion.ActivePotionEffect;
import me.adarsh.godspunkycore.features.region.Region;
import me.adarsh.godspunkycore.features.region.RegionType;
import me.adarsh.godspunkycore.features.slayer.SlayerQuest;
import me.adarsh.godspunkycore.listener.ServerRestartListener;
import me.adarsh.godspunkycore.sidebar.Sidebar;
import me.adarsh.godspunkycore.user.PlayerStatistic;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.DefenseReplacement;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.Sputnik;
import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftHumanEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Repeater {
    public static final Map<UUID, Integer> MANA_MAP = new HashMap<>();
    public static final Map<UUID, DefenseReplacement> DEFENSE_REPLACEMENT_MAP = new HashMap<>();

    private final List<BukkitTask> tasks;
    private final List<AtomicInteger> counters;

    private boolean serverRestartScheduled = false;

    private long restartStartTime = 0;

    public static final Map<UUID, Integer> FloorLivingSec = new HashMap<>();

    public Repeater() {
        this.tasks = new ArrayList<>();
        this.counters = new ArrayList<>(5);
        counters.add(new AtomicInteger());
        int[] counters = {0, 0};
        this.tasks.add(new BukkitRunnable() {
            public void run() {
                SkyBlockCalendar.ELAPSED += 10L;
                for (Player player : Bukkit.getOnlinePlayers()) {
                    PlayerInventory inventory = player.getInventory();

                    // Some Default Stuff
                    player.setSaturation(1000.0f);
                    player.setFoodLevel(20);
                    UUID uuid = player.getUniqueId();

                    // Add to Statistics Cache if not found
                    if (!PlayerUtils.STATISTICS_CACHE.containsKey(uuid))
                        PlayerUtils.STATISTICS_CACHE.put(uuid, PlayerUtils.getStatistics(player));
                    PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(uuid);

                    int manaPool = SUtil.blackMagic(100 + statistics.getIntelligence().addAll());

                    // Hand Validation and Hand Statistics
                    SItem hand = SItem.find(inventory.getItemInHand());
                    if (hand == null)
                    {
                        hand = SItem.of(inventory.getItemInHand());
                        if (hand != null)
                            player.setItemInHand(hand.getStack());
                    }
                    PlayerUtils.updateHandStatistics(hand, statistics);
                    PlayerUtils.updatePetStatistics(statistics);
                    User user = User.getUser(player.getUniqueId());
                    for (ActivePotionEffect effect : user.getEffects())
                        effect.setRemaining(effect.getRemaining() - 10);
                    PlayerUtils.updatePotionEffects(user, statistics);

                    if (hand != null)
                    {
                        if (hand.getType().getGenericInstance() instanceof Ownable)
                            hand.getData().setString("owner", player.getUniqueId().toString());
                        hand.update();
                        // Quiver Arrows
                        SItem last = SItem.find(inventory.getItem(8));
                        if (hand.getType().getStatistics().getSpecificType() == SpecificItemType.BOW && user.hasQuiverItem(SMaterial.ARROW)
                                && (last == null || last.getType() != SMaterial.QUIVER_ARROW)) {
                            inventory.setItem(8, SUtil.setStackAmount(SItem.of(SMaterial.QUIVER_ARROW).getStack(), Math.min(64, user.getQuiver(SMaterial.ARROW))));
                        }
                        if (hand.getType().getStatistics().getSpecificType() != SpecificItemType.BOW)
                            inventory.setItem(8, SItem.of(SMaterial.SKYBLOCK_MENU).getStack());
                    } else
                        inventory.setItem(8, SItem.of(SMaterial.SKYBLOCK_MENU).getStack());

                    // Mana Check
                    if (!MANA_MAP.containsKey(uuid)) MANA_MAP.put(uuid, manaPool);

                    // Mana Addition
                    if (counters[0] == 2) {
                        int mana = MANA_MAP.get(uuid);
                        if (mana <= manaPool) {
                            MANA_MAP.remove(uuid);
                            MANA_MAP.put(uuid, Math.min(manaPool, Math.min(manaPool, mana + (manaPool / 50) +
                                    (int) ((manaPool / 50) * statistics.getManaRegenerationPercentBonus()))));
                        }
                    }

                    // Health Addition
                    if (counters[1] == 4) {
                        if (player.getHealth() <= player.getMaxHealth()) {
                            player.setHealth(Math.min(player.getMaxHealth(), player.getHealth() + 1.5 + ((int) player.getMaxHealth() * 0.01) +
                                    ((1.5 + ((int) player.getMaxHealth() * 0.01)) * statistics.getHealthRegenerationPercentBonus())));
                        }
                    }

                    // Update Set
                    PlayerUtils.updateSetStatistics(player, SItem.find(inventory.getHelmet()),
                            SItem.find(inventory.getChestplate()), SItem.find(inventory.getLeggings()), SItem.find(inventory.getBoots()), statistics);
                    ItemListener.updateStatistics(player);

                    // Set Health Statistics
                    EntityHuman human = ((CraftHumanEntity) player).getHandle();
                    double health = statistics.getMaxHealth().addAll();
                    player.setHealthScale(Math.min(40.0, 20.0 + ((health - 100.0) / 25.0)));

                    // Set Speed Statistics
                    int defense = SUtil.blackMagic(statistics.getDefense().addAll());
                    player.setWalkSpeed(Math.min((float) (statistics.getSpeed().addAll() / 5.0), 1.0f));

                    // Display Action Bar
                    float absorption = human.getAbsorptionHearts();
                    ChatColor color = absorption > 0.0f ? ChatColor.GOLD : ChatColor.RED;
                    DefenseReplacement replacement = DEFENSE_REPLACEMENT_MAP.get(player.getUniqueId());
                    if (replacement != null && System.currentTimeMillis() >= replacement.getEnd()) {
                        DEFENSE_REPLACEMENT_MAP.remove(player.getUniqueId());
                        replacement = null;
                    }
                    SUtil.sendActionBar(player, color + "" + Math.round(player.getHealth() + absorption)
                            + "/" + SUtil.blackMagic(statistics.getMaxHealth().addAll()) + "❤     " +
                            (replacement == null ? (defense != 0 ? "" + ChatColor.GREEN + defense + "❈ Defense     " : "") :
                                    replacement.getReplacement() + "     ") +
                            ChatColor.AQUA + MANA_MAP.get(player.getUniqueId()) + "/" + manaPool + "✎ Mana");

                    // Ticking Armor Sets
                    statistics.zeroAll(PlayerStatistic.MINER_BUFF);
                    ArmorSet set = SMaterial.getIncompleteArmorSet(inventory);
                    if (set instanceof TickingSet)
                        ((TickingSet) set).tick(player, SItem.find(inventory.getHelmet()), SItem.find(inventory.getChestplate()), SItem.find(inventory.getLeggings()), SItem.find(inventory.getBoots()), Repeater.this.counters);

                    // Sidebar
                    Sidebar sidebar = new Sidebar("" + ChatColor.YELLOW + ChatColor.BOLD + "SKYBLOCK", "SKYBLOCK");
                    if (serverRestartScheduled) {
                        int secondsLeft = (int) Math.max(0, (restartStartTime + (ServerRestartListener.RESTART_INTERVAL_SECONDS * 1000) - System.currentTimeMillis()) / 1000);
                        String strd = ChatColor.RED + "Server closing: 00:" + (secondsLeft >= 10 ? secondsLeft : "0" + secondsLeft);
                        sidebar.add("  ");
                    }
                    sidebar.add(ChatColor.GRAY + SUtil.getDate());

                    sidebar.add("  ");
                    sidebar.add(" " + SkyBlockCalendar.getMonthName() + " " + SUtil.ntify(SkyBlockCalendar.getDay()));
                    boolean day = true;
                    int time = (int) ((SkyBlockCalendar.ELAPSED % 24000) - 6000);
                    if (time < 0)
                        time += 24000;
                    int hours = 6 + (time / 1000);
                    int minutes = (int) ((time % ((hours - 6) * 1000.0)) / 16.66666);
                    String sMin = String.valueOf(minutes);
                    minutes = minutes - Integer.parseInt(sMin.substring(sMin.length() - 1));
                    if (hours >= 24) hours -= 24;
                    if (hours <= 6 || hours >= 20) day = false;
                    sidebar.add(ChatColor.GRAY + " " + (hours > 12 ? hours - 12 : (hours == 0 ? 12 : hours)) + ":" + SUtil.zeroed(minutes) +
                            (hours >= 12 ? "pm" : "am") + " " + (day ? ChatColor.YELLOW + "☀" : ChatColor.AQUA + "☽"));
                    String location = "None";
                    Region region = Region.getRegionOfEntity(player);
                    if (region != null) {
                        user.setLastRegion(region);
                        if (region.getType().getName() != null)
                            location = region.getType().getColor() + region.getType().getName();
                    }
                    if (user.isOnIsland())
                        location = ChatColor.GREEN + "Your Island";

                    if(user.isPlayerOnDungeonWorld(player))
                        location = ChatColor.RED + "The Catacombs " + ChatColor.GRAY +"(F1)";

                    sidebar.add(ChatColor.GRAY + " ⏣ " + location);
                    sidebar.add(" ");
                    StringBuilder coinsDisplay = new StringBuilder();
                    if (user.isPermanentCoins())
                        coinsDisplay.append("Perma: ");
                    else if (PlayerUtils.hasItem(player, SMaterial.PIGGY_BANK))
                        coinsDisplay.append("Piggy: ");
                    else
                        coinsDisplay.append("Purse: ");
                    sidebar.add(coinsDisplay.append(ChatColor.GOLD).append(SUtil.commaify(user.getCoins())).toString());
                    sidebar.add("   ");
                    SlayerQuest quest = user.getSlayerQuest();
                    if (quest != null && quest.getDied() == 0) {
                        sidebar.add("Slayer Quest");
                        sidebar.add(quest.getType().getDisplayName());
                        if (quest.getKilled() != 0)
                            sidebar.add(ChatColor.GREEN + "Boss slain!");
                        else if (quest.getXp() >= quest.getType().getSpawnXP())
                            sidebar.add(ChatColor.YELLOW + "Slay the boss!");
                        else if (quest.getLastKilled() != null) {
                            sidebar.add(ChatColor.YELLOW + " " +
                                    SUtil.commaify((int) (quest.getXp() / quest.getLastKilled().getStatistics().getXPDropped())) + ChatColor.GRAY + "/" +
                                    ChatColor.RED + SUtil.commaify((int) (quest.getType().getSpawnXP() / quest.getLastKilled().getStatistics().getXPDropped())) +
                                    ChatColor.GRAY + " Kills");
                        } else {
                            sidebar.add(ChatColor.GRAY + " (" + ChatColor.YELLOW + SUtil.commaify((int) quest.getXp()) + ChatColor.GRAY +
                                    "/" + ChatColor.RED + SUtil.commaify(quest.getType().getSpawnXP()) + ChatColor.GRAY + ") Combat XP");
                        }
                        sidebar.add("    ");
                    }
                    if (StaticDragonManager.ACTIVE && StaticDragonManager.DRAGON != null && user.getLastRegion() != null &&
                            (user.getLastRegion().getType() == RegionType.THE_END || user.getLastRegion().getType() == RegionType.THE_END_NEST ||
                                    user.getLastRegion().getType() == RegionType.DRAGONS_NEST)) {
                        sidebar.add("Dragon HP: " + ChatColor.GREEN + SUtil.commaify((int) StaticDragonManager.DRAGON.getEntity().getHealth())
                                + ChatColor.RED + "❤");
                        if (StaticDragonManager.DRAGON.getDamageDealt().containsKey(uuid)) {
                            double dealt = StaticDragonManager.DRAGON.getDamageDealt().get(uuid);
                            sidebar.add("Your Damage: " + ChatColor.RED + SUtil.commaify(SUtil.roundTo(dealt, 1)));
                        }
                        sidebar.add("     ");
                    }
                    else if (player.getWorld().getName().contains("Dungeon_") && !player.getWorld().getName().equals("Dungeon_")) {
                        if (FloorLivingSec.containsKey(player.getWorld().getUID())) {
                            sidebar.add(ChatColor.translateAlternateColorCodes('&', "&fTime Elapsed: &a" + Sputnik.formatTime((Integer) FloorLivingSec.get(player.getWorld().getUID()))));
                        } else {
                            sidebar.add(ChatColor.translateAlternateColorCodes('&', "&fTime Elapsed: &a00m 00s"));
                        }
                        sidebar.add(ChatColor.translateAlternateColorCodes('&', "&fDungeon Cleared: &cN/A%"));
                        sidebar.add(ChatColor.RED + "  ");
                        String nameofplayer = player.getName();
                        if (player.getWorld().getPlayers().size() > 1) {
                            for (Player dungeonmate : player.getWorld().getPlayers()) {
                                String colorcode;
                                if (dungeonmate.getHealth() <= dungeonmate.getMaxHealth() / 2.0D && dungeonmate.getHealth() > dungeonmate.getMaxHealth() * 25.0D / 100.0D) {
                                    colorcode = "e";
                                } else if (dungeonmate.getHealth() <= dungeonmate.getMaxHealth() * 25.0D / 100.0D) {
                                    colorcode = "c";
                                } else {
                                    colorcode = "a";
                                }
                                String backend = " &" + colorcode + (int)dungeonmate.getHealth() + "&c❤";
                                if (dungeonmate.getName() == nameofplayer)
                                    continue;
                                sidebar.add(ChatColor.translateAlternateColorCodes('&', "&e[N/A&e] &b" + dungeonmate.getName() + backend));
                            }
                        } else if (player.getWorld().getPlayers().size() == 1) {
                            sidebar.add(ChatColor.DARK_GRAY + "No Teammates");
                        } else if (player.getWorld().getPlayers().size() > 5) {
                            sidebar.add(ChatColor.RED + "Something went wrong!");
                        }
                        sidebar.add(ChatColor.AQUA + "     ");
                    }
                    sidebar.add(ChatColor.YELLOW + "mc.godspunky.in");
                    sidebar.apply(player);
                    // Tablist
                    String activeEffects = user.getEffects().toString();
                    boolean hasActiveEffects = user.getEffects().size() > 0;

                    IChatBaseComponent header = new ChatComponentText(
                            ChatColor.AQUA + "You are" +  ChatColor.RESET + " " +  ChatColor.AQUA + "playing on " + ChatColor.YELLOW + "" + ChatColor.BOLD + "MC.GODSPUNKY.IN\n");
                    IChatBaseComponent footer = new ChatComponentText(
                            "\n" + ChatColor.GREEN + "" + ChatColor.BOLD + "Active Effects\n" + "" +
                                    (hasActiveEffects ? ChatColor.GRAY + "        You have " + ChatColor.YELLOW + user.getEffects().size() + ChatColor.GRAY + " active effects. Use\n" + ChatColor.GRAY + "\"" + ChatColor.GOLD + "/effects" + ChatColor.GRAY + "\" to see them!\n" + activeEffects + "\n" : ChatColor.GRAY + "         No effects active. Drink potions or splash\n" + ChatColor.GRAY + "them on the ground to buff yourself!\n\n") +
                                    ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Cookie Buff\n" + "" +
                                    ChatColor.GRAY + "Not active! Obtain booster cookies from the\n" + "community shop in the hub\n\n"+
                                    ChatColor.GREEN + "Ranks, Boosters, & MORE!" + ChatColor.RESET + " " + ChatColor.RED + "" + ChatColor.BOLD + "STORE.GODSPUNKY.IN");

                    PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();

                    try {
                        Field headerField = packet.getClass().getDeclaredField("a");
                        Field footerField = packet.getClass().getDeclaredField("b");
                        headerField.setAccessible(true);
                        footerField.setAccessible(true);
                        headerField.set(packet, header);
                        footerField.set(packet, footer);
                        headerField.setAccessible(!headerField.isAccessible());
                        footerField.setAccessible(!footerField.isAccessible());
                    } catch (Exception ex) {
                        Skyblock.getPlugin().sendMessage("&cFailed to register tab list for &8" + user.getBukkitPlayer().getName() + "&c: &8" + ex.getMessage() + "&c!");
                    }

                    ((CraftPlayer) user.getBukkitPlayer()).getHandle().playerConnection.sendPacket(packet);
                }
                counters[0]++;
                counters[1]++;
                if (counters[0] == 3)
                    counters[0] = 1;
                if (counters[1] == 5)
                    counters[1] = 1;
            }
        }.runTaskTimer(Skyblock.getPlugin(), 0, 10));
    }

    public void setServerRestartScheduled(boolean value) {
        serverRestartScheduled = value;
        if (value) {
            restartStartTime = System.currentTimeMillis();
        } else {
            restartStartTime = 0;
        }
    }

    public void stop() {
        for (BukkitTask task : this.tasks)
            task.cancel();
    }

}