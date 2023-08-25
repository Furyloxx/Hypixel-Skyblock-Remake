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

public class RevenantHorrorGUI extends GUI {
    public RevenantHorrorGUI() {
        super("Revenant Horror", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        fill(BLACK_STAINED_GLASS_PANE);
        Player player = e.getPlayer();
        set(GUIClickableItem.createGUIOpenerItem(GUIType.SLAYER, player, ChatColor.GREEN + "Go Back", 49, Material.ARROW, ChatColor.GRAY + "To Slayer"));
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                new SlayerConfirmGUI(SlayerBossType.REVENANT_HORROR_I, () -> User.getUser(player.getUniqueId()).startSlayerQuest(SlayerBossType.REVENANT_HORROR_I)).open(player);
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(SlayerBossType.REVENANT_HORROR_I.getDisplayName(), SlayerBossType.REVENANT_HORROR_I.getType().getIcon(),
                        (short) 0, 1, SlayerBossType.REVENANT_HORROR_I.asLore(true));
            }

            @Override
            public int getSlot() {
                return 11;
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                new SlayerConfirmGUI(SlayerBossType.REVENANT_HORROR_II, () -> User.getUser(player.getUniqueId()).startSlayerQuest(SlayerBossType.REVENANT_HORROR_II)).open(player);
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(SlayerBossType.REVENANT_HORROR_II.getDisplayName(), SlayerBossType.REVENANT_HORROR_II.getType().getIcon(),
                        (short) 0, 1, SlayerBossType.REVENANT_HORROR_II.asLore(true));
            }

            @Override
            public int getSlot() {
                return 12;
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                new SlayerConfirmGUI(SlayerBossType.REVENANT_HORROR_III, () -> User.getUser(player.getUniqueId()).startSlayerQuest(SlayerBossType.REVENANT_HORROR_III)).open(player);
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(SlayerBossType.REVENANT_HORROR_III.getDisplayName(), SlayerBossType.REVENANT_HORROR_III.getType().getIcon(),
                        (short) 0, 1, SlayerBossType.REVENANT_HORROR_III.asLore(true));
            }

            @Override
            public int getSlot() {
                return 13;
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                new SlayerConfirmGUI(SlayerBossType.REVENANT_HORROR_IV, () -> User.getUser(player.getUniqueId()).startSlayerQuest(SlayerBossType.REVENANT_HORROR_IV)).open(player);
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(SlayerBossType.REVENANT_HORROR_IV.getDisplayName(), SlayerBossType.REVENANT_HORROR_IV.getType().getIcon(),
                        (short) 0, 1, SlayerBossType.REVENANT_HORROR_IV.asLore(true));
            }

            public int getSlot() {
                return 14;
            }
        });
        set(new GUIClickableItem() {
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.DARK_PURPLE + "Boss Leveling Rewards", Material.GOLD_BLOCK, (short)0, 1, ChatColor.DARK_GRAY + "Zombie Slayer LVL", ChatColor.GRAY + " ",

                        Sputnik.trans("&51. &7Kill boss to get XP"),
                        Sputnik.trans("&52. &7Gain LVL from XP"),
                        Sputnik.trans("&53. &7Unlock rewards per LVL"),
                        Sputnik.trans(" "),
                        Sputnik.trans("&7Current LVL: &e" + SlayerBossType.SlayerMobType.ZOMBIE.getLevelForXP(User.getUser(player.getUniqueId()).getZombieSlayerXP())),
                        Sputnik.trans(" "),
                        Sputnik.trans("&7Zombie Slayer XP to LVL " + (SlayerBossType.SlayerMobType.ZOMBIE.getLevelForXP(User.getUser(player.getUniqueId()).getZombieSlayerXP()) + 1) + ":"),
                        Sputnik.trans(SUtil.createLineProgressBar(18, ChatColor.DARK_PURPLE, User.getUser(player.getUniqueId()).getZombieSlayerXP(), SlayerBossType.staticGetXPReqForLevel(SlayerBossType.SlayerMobType.ZOMBIE.getLevelForXP(User.getUser(player.getUniqueId()).getZombieSlayerXP()), EntityType.ZOMBIE))),
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
                return SUtil.getStack(ChatColor.GOLD + "Boss Drops", Material.GOLD_NUGGET, (short)0, 1, ChatColor.DARK_GRAY + "Revenant Horror", " ",

                        Sputnik.trans("&7Usually, the boss will drop"),
                        Sputnik.trans("&aRevenant Flesh&7."), " ",

                        Sputnik.trans("&7If you're lucky, you may get"),
                        Sputnik.trans("&7one of &9 &7possible"),
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
                return SUtil.getStack(ChatColor.GREEN + "Slayers Recipe", Material.BOOK, (short)0, 1, ChatColor.DARK_GRAY + "Revenant Horror", " ",

                        Sputnik.trans("&cFeature is not available!"));
            }

            public int getSlot() {
                return 33;
            }

            public void run(InventoryClickEvent e) {}
        });
    }
}