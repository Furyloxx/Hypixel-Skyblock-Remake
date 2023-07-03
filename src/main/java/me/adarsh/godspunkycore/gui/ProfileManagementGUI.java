package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.features.collection.ItemCollection;
import me.adarsh.godspunkycore.features.ranks.GodspunkyPlayer;
import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ProfileManagementGUI extends GUI {
    public ProfileManagementGUI() {
        super("Profile Management", 36);
    }
    @Override
    public void onOpen(GUIOpenEvent e) {
        fill(BLACK_STAINED_GLASS_PANE);
        Player player = e.getPlayer();
        User user = User.getUser(e.getPlayer().getUniqueId());
        set(GUIClickableItem.getCloseItem(31));

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.SKYBLOCK_MENU.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 30;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.GREEN + "Go Back", Material.ARROW, (short) 0, 1,
                        ChatColor.GRAY + "To SkyBlock Menu");
            }
        });

        String[] progress = ItemCollection.getProgress(player, null);
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 11;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.YELLOW + "Profile: "+ChatColor.GREEN+"Peach", Material.EMERALD_BLOCK, (short) 0, 1,
                        ChatColor.DARK_GRAY + "Selected Slot",
                        " ",
                        progress[0],
                        progress[1],
                        ChatColor.GRAY + "Recipe Book Unlocked: ",
                        progress[1],
                        " ",
                        ChatColor.GRAY + "Total Coin: " + ChatColor.GOLD + Math.addExact(user.getCoins(), user.getBankCoins()),
                        ChatColor.GRAY + "Age: N/A",
                        " ",
                        ChatColor.GREEN + "You are playing on this profile!");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 12;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.YELLOW + "Empty profile slot", Material.WOOD_BUTTON, (short) 0, 1,
                        ChatColor.DARK_GRAY + "Available",
                        " ",
                        ChatColor.GRAY + "Use this slot if you want to",
                        ChatColor.GRAY + "start a new SkyBlock",
                        ChatColor.GRAY + "adventure",
                        " ",
                        ChatColor.GRAY + "Each profile has its own:",
                        ChatColor.GRAY + "● Personal Island",
                        ChatColor.GRAY + "● Inventory",
                        ChatColor.GRAY + "● Ender Chest",
                        ChatColor.GRAY + "● Bank & Purse",
                        ChatColor.GRAY + "● Quests",
                        ChatColor.GRAY + "● Collections",
                        " ",
                        ChatColor.AQUA + "Right-Click to /coop",
                        ChatColor.YELLOW + "Click to create solo profile!");
            }
        });


        GodspunkyPlayer data = GodspunkyPlayer.getUser(e.getPlayer());
        if (data.rank == PlayerRank.VIP ){
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                }

                @Override
                public int getSlot() {
                    return 13;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.YELLOW + "Empty profile slot", Material.WOOD_BUTTON, (short) 0, 1,
                            ChatColor.DARK_GRAY + "Available",
                            " ",
                            ChatColor.GRAY + "Use this slot if you want to",
                            ChatColor.GRAY + "start a new SkyBlock",
                            ChatColor.GRAY + "adventure",
                            " ",
                            ChatColor.GRAY + "Each profile has its own:",
                            ChatColor.GRAY + "● Personal Island",
                            ChatColor.GRAY + "● Inventory",
                            ChatColor.GRAY + "● Ender Chest",
                            ChatColor.GRAY + "● Bank & Purse",
                            ChatColor.GRAY + "● Quests",
                            ChatColor.GRAY + "● Collections",
                            " ",
                            ChatColor.AQUA + "Right-Click to /coop",
                            ChatColor.YELLOW + "Click to create solo profile!");
                }
            });
        }else{
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                }

                @Override
                public int getSlot() {
                    return 13;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.RED + "Locked profile slot", Material.BEDROCK, (short) 0, 1,
                            ChatColor.DARK_GRAY + "Unavailable",
                            " ",
                            ChatColor.GRAY + "Requires "+ChatColor.GREEN+"[VIP]",
                            ChatColor.GOLD + "https://godspunky.store");
                }
            });
        }


        if (data.rank == PlayerRank.MVPPLUS ){
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                }

                @Override
                public int getSlot() {
                    return 14;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.YELLOW + "Empty profile slot", Material.WOOD_BUTTON, (short) 0, 1,
                            ChatColor.DARK_GRAY + "Available",
                            " ",
                            ChatColor.GRAY + "Use this slot if you want to",
                            ChatColor.GRAY + "start a new SkyBlock",
                            ChatColor.GRAY + "adventure",
                            " ",
                            ChatColor.GRAY + "Each profile has its own:",
                            ChatColor.GRAY + "● Personal Island",
                            ChatColor.GRAY + "● Inventory",
                            ChatColor.GRAY + "● Ender Chest",
                            ChatColor.GRAY + "● Bank & Purse",
                            ChatColor.GRAY + "● Quests",
                            ChatColor.GRAY + "● Collections",
                            " ",
                            ChatColor.AQUA + "Right-Click to /coop",
                            ChatColor.YELLOW + "Click to create solo profile!");
                }
            });
        }else{
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                }

                @Override
                public int getSlot() {
                    return 14;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.RED + "Locked profile slot", Material.BEDROCK, (short) 0, 1,
                            ChatColor.DARK_GRAY + "Unavailable",
                            " ",
                            ChatColor.GRAY + "Requires "+ChatColor.AQUA+"[MVP"+ChatColor.RED+"+"+ChatColor.AQUA+"]",
                            ChatColor.GOLD + "https://godspunky.store");
                }
            });


            set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                    }

                    @Override
                    public int getSlot() {
                        return 15;
                    }

                    @Override
                    public ItemStack getItem(){
                        return SUtil.getStack(ChatColor.RED + "Locked profile slot", Material.BEDROCK, (short) 0, 1,
                                ChatColor.DARK_GRAY + "Unavailable",
                                " ",
                                ChatColor.GRAY + "This slot is locked to you at",
                                ChatColor.GRAY + "this time but might be available",
                                ChatColor.GRAY + "in the future.");
                    }
                });
        }
    }
}
