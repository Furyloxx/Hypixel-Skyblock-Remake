package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.features.collection.ItemCollection;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class TradeGUI extends GUI {
    public TradeGUI() {
        super("Trade", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {

        fill(BLACK_STAINED_GLASS_PANE, 0, 9);
        fill(BLACK_STAINED_GLASS_PANE, 17, 18);
        fill(BLACK_STAINED_GLASS_PANE, 26, 27);
        fill(BLACK_STAINED_GLASS_PANE, 35, 36);
        fill(BLACK_STAINED_GLASS_PANE, 44, 53);

        Player player = e.getPlayer();

        User user = User.getUser(player.getUniqueId());
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId());
        set(GUIClickableItem.getCloseItem(49));

        // Arrow (back)
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.SKYBLOCK_MENU.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 48;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Go Back", Material.ARROW, (short) 0, 1,
                        ChatColor.GRAY + "To SkyBlock Menu");
            }
        });

        // TODO : MAKE IT FOR SB ITEMS {IT WORKS FOR VANILLA ONLY}

        // COAL
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {

                if (player.getInventory().contains(new ItemStack(Material.LOG))) {
                    player.getInventory().removeItem(new ItemStack(Material.LOG, 1));
                    player.getInventory().addItem(new ItemStack(SMaterial.COAL.getCraftMaterial(), 2));
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 2x Coal");
                    player.updateInventory();
                } else {
                    player.sendMessage(ChatColor.RED + "You don't have required items.");
                }
            }

            @Override
            public int getSlot() {
                return 10;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.WHITE + "Coal", Material.COAL, (short) 0, 1,
                        ChatColor.GRAY + "increases the speed of",
                        ChatColor.GRAY + "your minion by " + ChatColor.GREEN + "5%",
                        ChatColor.GRAY + "for 30 minutes!",
                        "",
                        ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                        "",
                        ChatColor.GRAY + "Cost",
                        ChatColor.WHITE + "Oak Wood",
                        "",
                        ChatColor.YELLOW + "Click to trade!");
            }
        });

        // GRASS
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {

                if (player.getInventory().contains(new ItemStack(Material.DIRT))) {
                    player.getInventory().removeItem(new ItemStack(Material.DIRT, 4));
                    player.getInventory().addItem(new ItemStack(Material.GRASS, 4));
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 4x Grass");
                    player.updateInventory();
                } else {
                    player.sendMessage(ChatColor.RED + "You don't have required items.");
                }
            }

            @Override
            public int getSlot() {
                return 11;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.WHITE + "Grass", Material.GRASS, (short) 0, 1,
                        ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                        "",
                        ChatColor.GRAY + "Cost",
                        ChatColor.WHITE + "Dirt" + ChatColor.GRAY + " x4",
                        "",
                        ChatColor.YELLOW + "Click to trade!");
            }
        });

        // DIRT
        if (user.hasCollection(ItemCollection.SEEDS, 1)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.SEEDS))) {
                        player.getInventory().removeItem(new ItemStack(Material.SEEDS, 8));
                        player.getInventory().addItem(new ItemStack(Material.DIRT, 2));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 2x Dirt");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 12;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Dirt", Material.DIRT, (short) 0, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Seed" + ChatColor.GRAY + " x8",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    player.sendMessage(ChatColor.RED + "Trade is locked!");
                }

                @Override
                public int getSlot() {
                    return 12;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                            "");
                }
            });
        }

        // CLAY
        if (user.hasCollection(ItemCollection.SEEDS, 2)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    player.sendMessage(ChatColor.RED + "Trade is locked!");
                }

                @Override
                public int getSlot() {
                    return 12;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                            "");
                }
            });
        } else {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    player.sendMessage(ChatColor.RED + "Trade is locked!");
                }

                @Override
                public int getSlot() {
                    return 13;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1, "");
                }
            });
        }

            // OAK LEAVE
        if (user.hasCollection(ItemCollection.OAK_WOOD, 2)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.SAPLING))) {
                        player.getInventory().removeItem(new ItemStack(Material.SAPLING, 1));
                        player.getInventory().addItem(new ItemStack(Material.LEAVES, 1));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Oak Leave");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 14;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Oak Leave", Material.LEAVES, (short) 0, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Oak Sapling",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    player.sendMessage(ChatColor.RED + "Trade is locked!");
                }

                @Override
                public int getSlot() {
                    return 14;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                            "");
                }
            });
        }

            // SPRUCE LEAVE
        if (user.hasCollection(ItemCollection.SPRUCE_WOOD, 2)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.SAPLING, (short) 1))) {
                        player.getInventory().removeItem(new ItemStack(Material.SAPLING, 1, (short) 1));
                        player.getInventory().addItem(new ItemStack(Material.LEAVES, 1, (short) 1));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Spruce Leave");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 15;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Spruce Leave", Material.LEAVES, (short) 1, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Spruce Sapling",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    player.sendMessage(ChatColor.RED + "Trade is locked!");
                }

                @Override
                public int getSlot() {
                    return 15;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                            "");
                }
            });
        }

            // BIRCH LEAVE
        if (user.hasCollection(ItemCollection.BIRCH_WOOD, 2)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.SAPLING, (short) 2))) {
                        player.getInventory().removeItem(new ItemStack(Material.SAPLING, 1, (short) 2));
                        player.getInventory().addItem(new ItemStack(Material.LEAVES, 1, (short) 2));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Birch Leave");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 16;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Birch Leave", Material.LEAVES, (short) 2, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Birch Sapling",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    player.sendMessage(ChatColor.RED + "Trade is locked!");
                }

                @Override
                public int getSlot() {
                    return 16;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                            "");
                }
            });
        }

        //JUNGLE LEAVE
        if (user.hasCollection(ItemCollection.JUNGLE_WOOD, 2)) {
        set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.SAPLING, (short) 3))) {
                        player.getInventory().removeItem(new ItemStack(Material.SAPLING, 1, (short) 3));
                        player.getInventory().addItem(new ItemStack(Material.LEAVES, 1, (short) 3));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Jungle Leave");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 19;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Jungle Leave", Material.LEAVES, (short) 3, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Jungle Sapling",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
        set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                        player.sendMessage(ChatColor.RED + "Trade is locked!");
                    }

                    @Override
                    public int getSlot() {
                        return 19;
                    }

                    @Override
                    public ItemStack getItem() {
                        return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                                "");
                    }
                });
        }

        // VINE
        if (user.hasCollection(ItemCollection.JUNGLE_WOOD, 4)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.LEAVES, (short) 3))) {
                        player.getInventory().removeItem(new ItemStack(Material.LEAVES, 5, (short) 3));
                        player.getInventory().addItem(new ItemStack(Material.VINE, 1));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Vine");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 20;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Vine", Material.VINE, (short) 1, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Jungle Leaves" + ChatColor.GRAY + " x5",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                        player.sendMessage(ChatColor.RED + "Trade is locked!");
                    }

                    @Override
                    public int getSlot() {
                        return 20;
                    }

                    @Override
                    public ItemStack getItem() {
                        return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                                "");
                    }
                });
        }

        // ACACIA LEAVE
        if (user.hasCollection(ItemCollection.ACACIA_WOOD, 2)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.SAPLING, (short) 4))) {
                        player.getInventory().removeItem(new ItemStack(Material.SAPLING, 1, (short) 4));
                        player.getInventory().addItem(new ItemStack(Material.LEAVES_2, 1));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Acacia Leave");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 21;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Acacia Leave", Material.LEAVES_2, (short) 0, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Acacia Sapling",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                        player.sendMessage(ChatColor.RED + "Trade is locked!");
                    }

                    @Override
                    public int getSlot() {
                        return 21;
                    }

                    @Override
                    public ItemStack getItem() {
                        return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                                "");
                    }
                });
        }

        // DARK OAK LEAVE
        if (user.hasCollection(ItemCollection.DARK_OAK_WOOD, 2)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.SAPLING, (short) 5))) {
                        player.getInventory().removeItem(new ItemStack(Material.SAPLING, 1, (short) 5));
                        player.getInventory().addItem(new ItemStack(Material.LEAVES_2, 1, (short) 1));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Dark Oak Leave");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 22;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Dark Oak Leave", Material.LEAVES_2, (short) 1, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Dark Oak Sapling",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                        player.sendMessage(ChatColor.RED + "Trade is locked!");
                    }

                    @Override
                    public int getSlot() {
                        return 22;
                    }

                    @Override
                    public ItemStack getItem() {
                        return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                                "");
                    }
                });
        }

        // ENCH BONE MEAL
        if (user.hasCollection(ItemCollection.BONE, 4)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.BONE))) {
                        player.getInventory().removeItem(new ItemStack(Material.BONE, 64));
                        player.getInventory().addItem(new ItemStack(SMaterial.ENCHANTED_BONE.getCraftMaterial(), 1));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Enchanted Bone Meal");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 23;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Enchanted Bone Meal", Material.INK_SACK, (short) 15, 1,
                            ChatColor.GRAY + "Instantly grow crops and",
                            ChatColor.GRAY + "saplings.",
                            "",
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Bone" + ChatColor.GRAY + " x64",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    player.sendMessage(ChatColor.RED + "Trade is locked!");
                }

                @Override
                public int getSlot() {
                    return 23;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                            "");
                }
            });
        }

        // LONG GRASS
        if (user.hasCollection(ItemCollection.SEEDS, 3)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.DIRT))) {
                        player.getInventory().removeItem(new ItemStack(Material.DIRT, 8));
                        player.getInventory().addItem(new ItemStack(Material.LONG_GRASS, 1));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Long Grass");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 24;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Long Grass", Material.LONG_GRASS, (short) 1, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Dirt" + ChatColor.GRAY + " x8",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                        player.sendMessage(ChatColor.RED + "Trade is locked!");
                    }

                    @Override
                    public int getSlot() {
                        return 24;
                    }

                    @Override
                    public ItemStack getItem() {
                        return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                                "");
                    }
                });
        }

        // Fern
        if (user.hasCollection(ItemCollection.SEEDS, 4)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.DIRT))) {
                        player.getInventory().removeItem(new ItemStack(Material.DIRT, 8));
                        player.getInventory().addItem(new ItemStack(Material.LONG_GRASS, 1, (short) 2));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Fern");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 25;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Fern", Material.LONG_GRASS, (short) 2, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Dirt" + ChatColor.GRAY + " x8",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                        player.sendMessage(ChatColor.RED + "Trade is locked!");
                    }

                    @Override
                    public int getSlot() {
                        return 25;
                    }

                    @Override
                    public ItemStack getItem() {
                        return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                                "");
                    }
                });
        }

            // DEAD BUSH
        if (user.hasCollection(ItemCollection.SEEDS, 5)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.DIRT))) {
                        player.getInventory().removeItem(new ItemStack(Material.DIRT, 8));
                        player.getInventory().addItem(new ItemStack(Material.DEAD_BUSH, 1));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Dead Bush");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 28;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Dead Bush", Material.DEAD_BUSH, (short) 0, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Dirt" + ChatColor.GRAY + " x8",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                        player.sendMessage(ChatColor.RED + "Trade is locked!");
                    }

                    @Override
                    public int getSlot() {
                        return 28;
                    }

                    @Override
                    public ItemStack getItem() {
                        return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                                "");
                    }
                });
        }

        // DOUBLE TALL GRASS
        if (user.hasCollection(ItemCollection.SEEDS, 6)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.DIRT))) {
                        player.getInventory().removeItem(new ItemStack(Material.DIRT, 8));
                        player.getInventory().addItem(new ItemStack(Material.DOUBLE_PLANT, 1, (short) 2));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Dead Bush");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 29;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Double Tall Grass", Material.DOUBLE_PLANT, (short) 2, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Dirt" + ChatColor.GRAY + " x8",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                        player.sendMessage(ChatColor.RED + "Trade is locked!");
                    }

                    @Override
                    public int getSlot() {
                        return 29;
                    }

                    @Override
                    public ItemStack getItem() {
                        return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                                "");
                    }
                });
        }

        // Water Bucket
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (user.getCoins() >= 12) {
                        player.getInventory().addItem(new ItemStack(Material.WATER_BUCKET, 1));
                        user.subCoins(12);
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Water Bucket");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required coins.");
                    }
                }

                @Override
                public int getSlot() {
                    return 30;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Water Bucket", Material.WATER_BUCKET, (short) 0, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.GOLD + "12 coins",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });

        // Lava Bucket
        if (user.hasCollection(ItemCollection.MAGMA_CREAM, 5)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (user.getCoins() >= 20) {
                        player.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET, 1));
                        user.subCoins(20);
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Lava Bucket");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required coins.");
                    }
                }

                @Override
                public int getSlot() {
                    return 31;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Lava Bucket", Material.LAVA_BUCKET, (short) 0, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.GOLD + "20 coins",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                        player.sendMessage(ChatColor.RED + "Trade is locked!");
                    }

                    @Override
                    public int getSlot() {
                        return 31;
                    }

                    @Override
                    public ItemStack getItem() {
                        return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                                "");
                    }
                });
        }

        // Milk Bucket
        if (user.hasCollection(ItemCollection.LEATHER, 2)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (user.getCoins() >= 50) {
                        player.getInventory().addItem(new ItemStack(Material.MILK_BUCKET, 1));
                        user.subCoins(50);
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Milk Bucket");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required coins.");
                    }
                }

                @Override
                public int getSlot() {
                    return 32;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Milk Bucket", Material.MILK_BUCKET, (short) 0, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.GOLD + "50 coins",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                        player.sendMessage(ChatColor.RED + "Trade is locked!");
                    }

                    @Override
                    public int getSlot() {
                        return 32;
                    }

                    @Override
                    public ItemStack getItem() {
                        return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                                "");
                    }
                });
        }

        // Soul Sand
        if (user.hasCollection(ItemCollection.SAND, 3)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.SAND)) && player.getInventory().contains(Material.FERMENTED_SPIDER_EYE)) {
                        player.getInventory().removeItem(new ItemStack(Material.SAND, 2));
                        player.getInventory().removeItem(new ItemStack(Material.FERMENTED_SPIDER_EYE, 1));
                        player.getInventory().addItem(new ItemStack(Material.SOUL_SAND, 1));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Soul Sand");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 33;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Soul Sand", Material.SOUL_SAND, (short) 0, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Sand" + ChatColor.GRAY + " x2",
                            ChatColor.WHITE + "Fermented Spider Eye",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                        player.sendMessage(ChatColor.RED + "Trade is locked!");
                    }

                    @Override
                    public int getSlot() {
                        return 33;
                    }

                    @Override
                    public ItemStack getItem() {
                        return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                                "");
                    }
                });
        }

        // Nether Brick
        if (user.hasCollection(ItemCollection.NETHERRACK, 3)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.NETHERRACK))) {
                        player.getInventory().removeItem(new ItemStack(Material.NETHERRACK, 1));
                        player.getInventory().addItem(new ItemStack(Material.NETHER_BRICK_ITEM, 1));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Nether Brick");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 34;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Nether Brick", Material.NETHER_BRICK_ITEM, (short) 0, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Netherrack",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                        player.sendMessage(ChatColor.RED + "Trade is locked!");
                    }

                    @Override
                    public int getSlot() {
                        return 34;
                    }

                    @Override
                    public ItemStack getItem() {
                        return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                                "");
                    }
                });
        }

        // WET SPONGE
        if (user.hasCollection(ItemCollection.SPONGE, 2)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {

                    if (player.getInventory().contains(new ItemStack(Material.SPONGE, (short) 1))) {
                        player.getInventory().removeItem(new ItemStack(Material.SPONGE, 1, (short) 1));
                        player.getInventory().addItem(new ItemStack(Material.SPONGE, 1));
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] 1x Sponge");
                        player.updateInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have required items.");
                    }
                }

                @Override
                public int getSlot() {
                    return 37;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.WHITE + "Sponge", Material.SPONGE, (short) 0, 1,
                            ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON",
                            "",
                            ChatColor.GRAY + "Cost",
                            ChatColor.WHITE + "Wet Sponge",
                            "",
                            ChatColor.YELLOW + "Click to trade!");
                }
            });
        } else {
            set(new GUIClickableItem() {
                    @Override
                    public void run(InventoryClickEvent e) {
                        player.sendMessage(ChatColor.RED + "Trade is locked!");
                    }

                    @Override
                    public int getSlot() {
                        return 37;
                    }

                    @Override
                    public ItemStack getItem() {
                        return SUtil.getStack(ChatColor.RED + "Trade is locked!", Material.INK_SACK, (short) 8, 1,
                                "");
                    }
                });
        }
    }
}

