package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class StorageGUI extends GUI {
    public StorageGUI() {
        super("Storage", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        fill(BLACK_STAINED_GLASS_PANE);

        fill(RED_STAINED_GLASS_PANE,12,17);

        Player player1 = e.getPlayer();

        User user = User.getUser(player1.getUniqueId());
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player1.getUniqueId());
        set(GUIClickableItem.getCloseItem(49));

        // Arrow (back)
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.SKYBLOCK_MENU.getGUI().open(player1);
            }

            @Override
            public int getSlot() {
                return 48;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.GREEN + "Go Back", Material.ARROW, (short) 0, 1,
                        ChatColor.GRAY + "To SkyBlock Menu");
            }
        });

        // Ender Chest Info
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 4;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Ender Chest", Material.ENDER_CHEST, (short) 0, 1,
                        ChatColor.GRAY + "Store global items you can",
                        ChatColor.GRAY + "access anywhere in your ender",
                        ChatColor.GRAY + "chest.");
            }
        });

        // Ender Storage 1
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                player1.playSound(player1.getLocation(), Sound.CHEST_OPEN, 1f, 0f);
                player1.openInventory(player1.getEnderChest());
            }

            @Override
            public int getSlot() {
                return 9;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Ender Chest Page 1", Material.STAINED_GLASS_PANE, (short) 10, 1,
                        " ",
                        ChatColor.YELLOW + "Left-Click to open!");
            }
        });

        // Ender Storage 2
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                player1.playSound(player1.getLocation(), Sound.CHEST_OPEN, 1f, 0f);
                player1.openInventory(player1.getEnderChest());
            }

            @Override
            public int getSlot() {
                return 10;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Ender Chest Page 2", Material.STAINED_GLASS_PANE, (short) 10, 1,
                        " ",
                        ChatColor.YELLOW + "Left-Click to open!");
            }
        });

        // Ender Storage 3
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                player1.playSound(player1.getLocation(), Sound.CHEST_OPEN, 1f, 0f);
                player1.openInventory(player1.getEnderChest());
            }

            @Override
            public int getSlot() {
                return 11;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Ender Chest Page 3", Material.STAINED_GLASS_PANE, (short) 10, 1,
                        " ",
                        ChatColor.YELLOW + "Left-Click to open!");
            }
        });

        // Backpack
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 22;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Backpack", Material.CHEST, (short) 0, 1,
                        ChatColor.GRAY + "Place backpack items in these",
                        ChatColor.GRAY + "slots to use them as additional",
                        ChatColor.GRAY + "storage that can be accessed",
                        ChatColor.GRAY + "anywhere.");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 27;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Empty Backpack Slot 1", Material.STAINED_GLASS_PANE, (short) 12, 1,
                        "");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 28;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Empty Backpack Slot 2", Material.STAINED_GLASS_PANE, (short) 12, 1,
                        "");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 29;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Empty Backpack Slot 3", Material.STAINED_GLASS_PANE, (short) 12, 1,
                        "");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 30;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Empty Backpack Slot 4", Material.STAINED_GLASS_PANE, (short) 12, 1,
                        "");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 31;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Empty Backpack Slot 5", Material.STAINED_GLASS_PANE, (short) 12, 1,
                        "");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 32;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Empty Backpack Slot 6", Material.STAINED_GLASS_PANE, (short) 12, 1,
                        "");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 33;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Empty Backpack Slot 7", Material.STAINED_GLASS_PANE, (short) 12, 1,
                        "");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 34;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Empty Backpack Slot 8", Material.STAINED_GLASS_PANE, (short) 12, 1,
                        "");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 35;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Empty Backpack Slot 9", Material.STAINED_GLASS_PANE, (short) 12, 1,
                        "");
            }
        });

    }
}