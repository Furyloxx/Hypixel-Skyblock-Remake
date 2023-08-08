package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.features.slayer.SlayerBossType;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.Sputnik;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class TarantulaBroodfatherGUI extends GUI {
    public TarantulaBroodfatherGUI() {
        super("Tarantula Broodfather", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        fill(BLACK_STAINED_GLASS_PANE);
        Player player = e.getPlayer();
        set(GUIClickableItem.createGUIOpenerItem(GUIType.SLAYER, player, ChatColor.GREEN + "Go Back", 49, Material.ARROW, ChatColor.GRAY + "To Slayer"));
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                new SlayerConfirmGUI(SlayerBossType.TARANTULA_BROODFATHER_I, () -> User.getUser(player.getUniqueId()).startSlayerQuest(SlayerBossType.TARANTULA_BROODFATHER_I)).open(player);
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(SlayerBossType.TARANTULA_BROODFATHER_I.getDisplayName(), SlayerBossType.TARANTULA_BROODFATHER_I.getType().getIcon(),
                        (short) 0, 1, SlayerBossType.TARANTULA_BROODFATHER_I.asLore(true));
            }

            @Override
            public int getSlot() {
                return 11;
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                new SlayerConfirmGUI(SlayerBossType.TARANTULA_BROODFATHER_II, () -> User.getUser(player.getUniqueId()).startSlayerQuest(SlayerBossType.TARANTULA_BROODFATHER_II)).open(player);
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(SlayerBossType.TARANTULA_BROODFATHER_II.getDisplayName(), SlayerBossType.TARANTULA_BROODFATHER_II.getType().getIcon(),
                        (short) 0, 1, SlayerBossType.TARANTULA_BROODFATHER_II.asLore(true));
            }

            @Override
            public int getSlot() {
                return 12;
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                new SlayerConfirmGUI(SlayerBossType.TARANTULA_BROODFATHER_III, () -> User.getUser(player.getUniqueId()).startSlayerQuest(SlayerBossType.TARANTULA_BROODFATHER_III)).open(player);
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(SlayerBossType.TARANTULA_BROODFATHER_III.getDisplayName(), SlayerBossType.TARANTULA_BROODFATHER_III.getType().getIcon(),
                        (short) 0, 1, SlayerBossType.TARANTULA_BROODFATHER_III.asLore(true));
            }

            @Override
            public int getSlot() {
                return 13;
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                new SlayerConfirmGUI(SlayerBossType.TARANTULA_BROODFATHER_IV, () -> User.getUser(player.getUniqueId()).startSlayerQuest(SlayerBossType.TARANTULA_BROODFATHER_IV)).open(player);
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(SlayerBossType.TARANTULA_BROODFATHER_IV.getDisplayName(), SlayerBossType.TARANTULA_BROODFATHER_IV.getType().getIcon(),
                        (short) 0, 1, SlayerBossType.TARANTULA_BROODFATHER_IV.asLore(true));
            }

            @Override
            public int getSlot() {
                return 14;
            }
        });

        set(new GUIClickableItem() {
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.DARK_PURPLE + "Boss Leveling Rewards", Material.GOLD_BLOCK, (short)0, 1, ChatColor.DARK_GRAY + "Spider Slayer LVL", ChatColor.GRAY + " ",

                        Sputnik.trans("&51. &7Kill boss to get XP"),
                        Sputnik.trans("&52. &7Gain LVL from XP"),
                        Sputnik.trans("&53. &7Unlock rewards per LVL"),
                        Sputnik.trans(" "),
                        Sputnik.trans("&7Current LVL: &e" + SlayerBossType.SlayerMobType.SPIDER.getLevelForXP(User.getUser(player.getUniqueId()).getSpiderSlayerXP())),
                        Sputnik.trans(" "),
                        Sputnik.trans("&7Spider Slayer XP to LVL " + (SlayerBossType.SlayerMobType.SPIDER.getLevelForXP(User.getUser(player.getUniqueId()).getSpiderSlayerXP()) + 1) + ":"),
                        Sputnik.trans(SUtil.createLineProgressBar(18, ChatColor.DARK_PURPLE, User.getUser(player.getUniqueId()).getSpiderSlayerXP(), SlayerBossType.staticGetXPReqForLevel(SlayerBossType.SlayerMobType.SPIDER.getLevelForXP(User.getUser(player.getUniqueId()).getSpiderSlayerXP()), EntityType.SPIDER))),
                        " ",

                        Sputnik.trans("&cNot available on Semi-Sandbox mode!"));
            }

            public int getSlot() {
                return 29;
            }

            public void run(InventoryClickEvent e) {}
        });
        set(new GUIClickableItem() {
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GOLD + "Boss Drops", Material.GOLD_NUGGET, (short)0, 1, ChatColor.DARK_GRAY + "Tarantula Broodfather", " ",

                        Sputnik.trans("&7Usually, the boss will drop"),
                        Sputnik.trans("&aTarantula Web&7."), " ",

                        Sputnik.trans("&7If you're lucky, you may get"),
                        Sputnik.trans("&7one of &d6 &7possible"),
                        Sputnik.trans("&7drops from this boss."), " ",

                        Sputnik.trans("&cMenu is not available!"));
            }

            public int getSlot() {
                return 31;
            }

            public void run(InventoryClickEvent e) {}
        });
        set(new GUIClickableItem() {
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Slayers Recipe", Material.BOOK, (short)0, 1, ChatColor.DARK_GRAY + "Tarantula Broodfather", " ",

                        Sputnik.trans("&cFeature is not available!"));
            }

            public int getSlot() {
                return 33;
            }

            public void run(InventoryClickEvent e) {}
        });
    }
}