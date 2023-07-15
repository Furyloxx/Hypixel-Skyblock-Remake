package me.adarsh.godspunkycore.features.gui;

import me.adarsh.godspunkycore.features.collection.ItemCollection;
import me.adarsh.godspunkycore.features.item.pet.Pet;
import me.adarsh.godspunkycore.features.wardrobe.GUI.WardrobeGUI;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SkyBlockMenuGUI extends GUI {
    public SkyBlockMenuGUI() {
        super("SkyBlock Menu", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        fill(BLACK_STAINED_GLASS_PANE);
        Player player = e.getPlayer();
        User user = User.getUser(player.getUniqueId());
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId());

        // Player Profile

        set(GUIClickableItem.getCloseItem(49));
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.SKYBLOCK_PROFILE.getGUI().open((Player) e.getWhoClicked());
            }

            @Override
            public int getSlot() {
                return 13;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullStack(ChatColor.GREEN + "Your SkyBlock Profile", player.getName(), 1,
                        ChatColor.RED + "  ❤ Health " + ChatColor.WHITE + SUtil.commaify(statistics.getMaxHealth().addAll()) + " HP",
                        ChatColor.GREEN + "  ❈ Defense " + ChatColor.WHITE + SUtil.commaify(statistics.getDefense().addAll()),
                        ChatColor.RED + "  ❁ Strength " + ChatColor.WHITE + SUtil.commaify(statistics.getStrength().addAll()),
                        ChatColor.WHITE + "  ✦ Speed " + SUtil.commaify(((Double) (statistics.getSpeed().addAll() * 100.0)).intValue()),
                        ChatColor.BLUE + "  ☣ Crit Chance " + ChatColor.WHITE + SUtil.commaify(((Double) (statistics.getCritChance().addAll() * 100.0)).intValue()) + "%",
                        ChatColor.BLUE + "  ☠ Crit Damage " + ChatColor.WHITE + SUtil.commaify(((Double) (statistics.getCritDamage().addAll() * 100.0)).intValue()) + "%",
                        ChatColor.AQUA + "  ✎ Intelligence " + ChatColor.WHITE + SUtil.commaify(statistics.getIntelligence().addAll()),
                        ChatColor.YELLOW + "  ⚔ Bonus Attack Speed " + ChatColor.RED + "✗",
                        ChatColor.DARK_AQUA + "  α Sea Creature Chance " + ChatColor.RED + "✗",
                        ChatColor.LIGHT_PURPLE + "  ♣ Pet Luck " + ChatColor.RED + "✗",
                        " ",
                        ChatColor.YELLOW + "Click to view your profile!");
            }
        });

        // SKILLS

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.SKILL_MENU.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 19;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Your Skills", Material.DIAMOND_SWORD, (short) 0, 1,
                        ChatColor.GRAY + "View your Skill progression and",
                        ChatColor.GRAY + "rewards.",
                        " ",
                        ChatColor.YELLOW + "Click to view!");
            }
        });

        // COLLECTION

        String[] progress = ItemCollection.getProgress(player, null);
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.COLLECTION_MENU.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 20;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Collection", Material.PAINTING, (short) 0, 1,
                        ChatColor.GRAY + "View all of the items available",
                        ChatColor.GRAY + "in SkyBlock. Collect more of an",
                        ChatColor.GRAY + "item to unlock rewards on your",
                        ChatColor.GRAY + "way to becoming a master of",
                        ChatColor.GRAY + "SkyBlock!",
                        " ",
                        progress[0],
                        progress[1],
                        " ",
                        ChatColor.YELLOW + "Click to view!");
            }
        });

        // RECIPE BOOK

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                // add
            }

            @Override
            public int getSlot() {
                return 21;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Recipe Book", Material.BOOK, (short) 0, 1,
                        ChatColor.GRAY + "Through your adventure, you will",
                        ChatColor.GRAY + "unlock recipes for all kinds of",
                        ChatColor.GRAY + "special items! You can view how",
                        ChatColor.GRAY + "to craft these items here",
                        "",
                        ChatColor.YELLOW + "Click to view!");
            }
        });

        // TRADE

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.TRADE.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 22;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Trade", Material.EMERALD, (short) 0, 1,
                        "",
                        ChatColor.YELLOW + "Click to view!");
            }
        });

        // QUEST LOG

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.QUEST.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 23;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Quest Log", Material.BOOK_AND_QUILL, (short) 0, 1,
                        ChatColor.GRAY + "View your active quests,",
                        ChatColor.GRAY + "progress, and rewards.",
                        "",
                        ChatColor.YELLOW + "Click to view!");
            }
        });

        // Calendar And Event

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.CALENDAR.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 24;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Calendar and Event", Material.WATCH, (short) 0, 1,
                        ChatColor.GRAY + "View the SkyBlock Calendar,",
                        ChatColor.GRAY + "upcoming events, and event",
                        ChatColor.GRAY + "rewards!",
                        "",
                        ChatColor.GRAY + "Next Event: " + ChatColor.YELLOW + "N/A",
                        ChatColor.GRAY + "Starting in: " + ChatColor.YELLOW + "N/A",
                        "",
                        ChatColor.YELLOW + "Click to view!");
            }
        });

        // ENDER CHEST

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 1f, 0f);
                GUIType.STORAGE.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 25;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Ender Chest", Material.ENDER_CHEST,
                        (short) 0, 1,
                        ChatColor.GRAY + "Store global items that you want",
                        ChatColor.GRAY + "to access at any time from",
                        ChatColor.GRAY + "anywhere here.",
                        " ",
                        ChatColor.YELLOW + "Click to open!");
            }
        });

        // POTION AND EFFECT

        if (user.getEffects().size() > 0) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    GUIType.ACTIVE_EFFECTS.getGUI().open(player);
                }

                @Override
                public int getSlot() {
                    return 29;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.GREEN + "Active Effects", Material.POTION, (short) 0, 1,
                            ChatColor.GRAY + "View and manage all of your",
                            ChatColor.GRAY + "active potion effects.",
                            " ",
                            ChatColor.GRAY + "Drink Potions or splash them",
                            ChatColor.GRAY + "on the ground to buff yourself!",
                            " ",
                            ChatColor.GRAY + "Currently Active: " + ChatColor.YELLOW + user.getEffects().size());
                }
            });
        }

        // PETS

        if (user.getPets().size() > 0) {
            Pet.PetItem active = user.getActivePet();
            String name;
            if (active == null)
                name = ChatColor.RED + "None";
            else
                name = active.getRarity().getColor() + active.getType().getDisplayName(active.getType().getData());
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    GUIType.PETS.getGUI().open(player);
                }

                @Override
                public int getSlot() {
                    return 30;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.GREEN + "Pets", Material.BONE, (short) 0, 1,
                            ChatColor.GRAY + "View and manage all of your",
                            ChatColor.GRAY + "Pets.",
                            " ",
                            ChatColor.GRAY + "Level up your pets faster by",
                            ChatColor.GRAY + "gaining XP in their favorite",
                            ChatColor.GRAY + "skill!",
                            " ",
                            ChatColor.GRAY + "Selected pet: " + name,
                            " ",
                            ChatColor.YELLOW + "Click to view!");
                }
            });
        }

        // CRAFTING

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.CRAFTING_TABLE.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 31;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Crafting Table", Material.WORKBENCH, (short) 0, 1,
                        ChatColor.GRAY + "Opens the crafting grid.",
                        " ",
                        ChatColor.YELLOW + "Click to open!");
            }
        });

        // QUIVER {REQUIRES STRING III}

        if (user.hasCollection(ItemCollection.STRING, 3)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    GUIType.QUIVER.getGUI().open(player);
                }

                @Override
                public int getSlot() {
                    return 44;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "Quiver", "4cb3acdc11ca747bf710e59f4c8e9b3d949fdd364c6869831ca878f0763d1787", 1,
                            ChatColor.GRAY + "A masterfully crafted Quiver",
                            ChatColor.GRAY + "which holds any kind of",
                            ChatColor.GRAY + "projectile you can think of!",
                            " ",
                            ChatColor.YELLOW + "Click to open!");
                }
            });
        }
        
        // Accessory Bag {REQUIRES REDSTONE II}

        if (user.hasCollection(ItemCollection.REDSTONE, 2)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    GUIType.ACCESSORY_BAG.getGUI().open(player);
                }

                @Override
                public int getSlot() {
                    return 52;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "Accessory Bag", "961a918c0c49ba8d053e522cb91abc74689367b4d8aa06bfc1ba9154730985ff", 1,
                            ChatColor.GRAY + "A special bag that can hold",
                            ChatColor.GRAY + "Talisman, Rings, Artifacts and",
                            ChatColor.GRAY + "Orbs within it. All will still",
                            ChatColor.GRAY + "work while in the bag!",
                            " ",
                            ChatColor.YELLOW + "Click to open!");
                }
            });
        }

        // Potion Bag {REQUIRES NETHER WART II}

        if (user.hasCollection(ItemCollection.NETHER_WARTS, 2)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    GUIType.POTION_BAG.getGUI().open(player);
                }

                @Override
                public int getSlot() {
                    return 53;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "Potion Bag", "60226d4c1d30fbebecae939da900603e4cd0fed8592a1bb3e11f9ac92391a45a", 1,
                            ChatColor.GRAY + "A handy bag for holding your",
                            ChatColor.GRAY + "potions in.",
                            " ",
                            ChatColor.YELLOW + "Click to open!");
                }
            });
        }

        // PIGGY BANK {REQUIRES EMERALD 7}

        if (user.hasCollection(ItemCollection.EMERALD, 7)) {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    GUIType.BANKER.getGUI().open(player);
                }

                @Override
                public int getSlot() {
                    return 33;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "Personal Bank", "209299a117bee88d3262f6ab98211fba344ecae39b47ec848129706dedc81e4f", 1,
                            ChatColor.GRAY + "Contact your banker from",
                            ChatColor.GRAY + "anywhere.",
                            ChatColor.GRAY + "Cooldown:" + ChatColor.RED + " Soon",
                            " ",
                            ChatColor.GRAY + "Banker Status:",
                            ChatColor.GREEN + "Availabe");
                }
            });
        }

        // WARDROBE

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                WardrobeGUI.CreateWardrobePage1(player);
            }

            @Override
            public int getSlot() {
                return 32;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Wardrobe", Material.LEATHER_CHESTPLATE, (short) 0, 1,
                        ChatColor.GRAY + "Store armor sets and quickly",
                        ChatColor.GRAY + "swap between them!",
                        " ",
                        ChatColor.YELLOW + "Click to open!");
            }
        });

        // SETTINGS

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.SETTING.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 50;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Setting", Material.REDSTONE_TORCH_ON,
                        (short) 0, 1,
                        ChatColor.GRAY + "View and edit your SkyBlock",
                        ChatColor.GRAY + "Settings.",
                        " ",
                        ChatColor.YELLOW + "Click to view!");
            }
        });

        // WARPS

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.FAST_TRAVEL.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 47;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getSkullURLStack(ChatColor.AQUA+ "Fast Travel", "c9c8881e42915a9d29bb61a16fb26d059913204d265df5b439b3d792acd56", 1,
                        ChatColor.GRAY + "Teleport to islands you've",
                        ChatColor.GRAY + "already visited.",
                        "",
                        ChatColor.YELLOW + "Click to pick location!");
            }
        });

        // PROFILE MANAGEMENT TODO:
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.ProfileManagementGUI.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 48;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Profile Management", Material.NAME_TAG,
                        (short) 0, 1,
                        ChatColor.GRAY + "You can have multiple",
                        ChatColor.GRAY + "SkyBlock profiles at the",
                        ChatColor.GRAY + "same time.",
                        " ",
                        ChatColor.GRAY + "Each profile has its own",
                        ChatColor.GRAY + "island, inventory, ques",
                        ChatColor.GRAY + "logs...",
                        " ",
                        ChatColor.GRAY + "Profiles: " + ChatColor.YELLOW + "1/4",
                        " ",
                        ChatColor.AQUA + "Play with friends using /coop",
                        " ",
                        ChatColor.YELLOW + "Click to manage!");
            }
        });

        // BOOSTER COOKIE
        set(new GUIClickableItem() {
            String bits = PlaceholderAPI.setPlaceholders(player, "%royaleeconomy_balance_purse%");
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.COOKIE_INFO.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 51;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GOLD + "Booster Cookie", Material.COOKIE,
                        (short) 0, 1,
                        ChatColor.GRAY + "Obtain the " + ChatColor.LIGHT_PURPLE + "Cookie Buff",
                        ChatColor.GRAY + "from Booster Cookie in the",
                        ChatColor.GRAY + "hub'sCommunity Shop.",
                        " ",
                        ChatColor.GRAY + "Duration: " + ChatColor.GREEN + PlayerUtils.getCookieDurationTicks(player),
                        ChatColor.GRAY + "Bits Available: " + ChatColor.AQUA + bits,
                        " ",
                        ChatColor.YELLOW + "Click to get all info!");
            }
        });
    }

}