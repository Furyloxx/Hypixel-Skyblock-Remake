package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.collection.ItemCollection;
import me.godspunky.skyblock.user.PlayerUtils;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class FastTravelGUI_2 extends GUI {
    private Skyblock plugin = Skyblock.getPlugin();

    public FastTravelGUI_2() {
        super("Fast Travel", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        fill(BLACK_STAINED_GLASS_PANE);
        Player player = e.getPlayer();
        User user = User.getUser(e.getPlayer().getUniqueId());
        set(GUIClickableItem.getCloseItem(49));

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
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.GREEN + "Go Back", Material.ARROW, (short) 0, 1,
                        ChatColor.GRAY + "To SkyBlock Menu");
            }
        });

        // ISLAND

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                PlayerUtils.sendToIsland(player);
            }

            @Override
            public int getSlot() {
                return 10;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.AQUA + "Private Island", Material.PAPER, (short) 0, 1,
                        ChatColor.DARK_GRAY + "/warp home",
                        " ",
                        ChatColor.GRAY + "Your very own chunk of SkyBlock.",
                        ChatColor.GRAY + "Nice housing for your minions.",
                        " ",
                        ChatColor.YELLOW + "Click to warp!");
            }
        });

        // HUB

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                Player player1 = (Player) e.getWhoClicked();
                World hub = Bukkit.getWorld(plugin.getConfig().getString("hub_world"));
                player1.teleport(new Location(hub, -3 , 70 , -68));
            }

            @Override
            public int getSlot() {
                return 11;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.AQUA + "Skyblock Hub", Material.PAPER, (short) 0, 1,
                        ChatColor.DARK_GRAY + "/warp hub",
                        " ",
                        ChatColor.GRAY + "Where everything happens and",
                        ChatColor.GRAY + "anything is possible.",
                        " ",
                        ChatColor.YELLOW + "Click to warp!");
            }

        });

        // DUNGEON TODO: coordinates

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                Location loc = new Location(Bukkit.getWorld("DHub"), -45,88,13);
                Player player1 = (Player) e.getWhoClicked();
                player1.teleport(loc);
            }

            @Override
            public int getSlot() {
                return 12;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Dungeon Hub " + ChatColor.DARK_GRAY + "- " + ChatColor.AQUA + "Spawn", Material.BEDROCK, (short) 0, 1,
                        ChatColor.DARK_GRAY + "/warp dungeon_hub",
                        " ",
                        ChatColor.GRAY + "Group with friends and take on",
                        ChatColor.GRAY + "challenging Dungeons.");
            }
        });

        // The Barn
        if (user.hasCollection(ItemCollection.POTATO, 6)){
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    World the_barn = Bukkit.getWorld(plugin.getConfig().getString("hub_world"));
                    player1.teleport(new Location(the_barn, 114 , 71 , -207));
                }

                @Override
                public int getSlot() {
                    return 13;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.GREEN + "The Barn" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.PAPER, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp barn",
                            " ",
                            ChatColor.GRAY + "Collect basic farming resource",
                            ChatColor.GRAY + "from plentiful crops or the local",
                            ChatColor.GRAY + "animal population.",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Farming",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "I",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }

            });
        }else {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                    player1.sendMessage(plugin.getPrefix() + "You need Potato Collection level 6 to use this");
                }

                @Override
                public int getSlot() {
                    return 13;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.GREEN + "The Barn" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.BEDROCK, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp barn",
                            " ",
                            ChatColor.GRAY + "Collect basic farming resource",
                            ChatColor.GRAY + "from plentiful crops or the local",
                            ChatColor.GRAY + "animal population.",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Farming",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "I",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }
            });
        }


        // The Park

        if (user.hasCollection(ItemCollection.BIRCH_WOOD, 7)){
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    World park = Bukkit.getWorld(plugin.getConfig().getString("hub_world"));
                    player1.teleport(new Location(park, -276 , 82 , -12));
                }

                @Override
                public int getSlot() {
                    return 14;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.GREEN + "The Park" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.PAPER, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp park",
                            " ",
                            ChatColor.GRAY + "Chop down trees and explore to",
                            ChatColor.GRAY + "meet various characters across",
                            ChatColor.GRAY + "different biome layers.",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Foraging",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "I",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }

            });
        }else {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                    player1.sendMessage(plugin.getPrefix()+ "You need Birch Wood collection level 7 to use this");
                }

                @Override
                public int getSlot() {
                    return 14;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.GREEN + "The Park" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.BEDROCK, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp park",
                            " ",
                            ChatColor.GRAY + "Chop down trees and explore to",
                            ChatColor.GRAY + "meet various characters across",
                            ChatColor.GRAY + "different biome layers.",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Foraging",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "I",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }

            });
        }

        // Gold Mine

        if (user.hasCollection(ItemCollection.COAL, 6)){
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    World gold_mine = Bukkit.getWorld(plugin.getConfig().getString("hub_world"));
                    player1.teleport(new Location(gold_mine, -4 , 74 , -273));
                }

                @Override
                public int getSlot() {
                    return 15;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.GREEN + "Gold Mine" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.PAPER, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp gold",
                            " ",
                            ChatColor.GRAY + "our first stop for extended",
                            ChatColor.GRAY + "mining related activities and home",
                            ChatColor.GRAY + "to SkyBlock's local janitor Rusty.",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Mining",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "I",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }

            });
        }else {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                    player1.sendMessage(plugin.getPrefix() + "You need Coal Collection level 6 to use this.");
                }

                @Override
                public int getSlot() {
                    return 15;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.GREEN + "Gold Mine" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.BEDROCK, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp gold",
                            " ",
                            ChatColor.GRAY + "our first stop for extended",
                            ChatColor.GRAY + "mining related activities and home",
                            ChatColor.GRAY + "to SkyBlock's local janitor Rusty.",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Mining",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "I",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }

            });
        }

        // Deep Caverns

        if (user.hasCollection(ItemCollection.REDSTONE, 7)){
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    World deep_caverns = Bukkit.getWorld(plugin.getConfig().getString("hub_world"));
                    player1.teleport(new Location(deep_caverns, -2 , 178 , -458));
                }

                @Override
                public int getSlot() {
                    return 16;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.GREEN + "Deep Caverns" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.PAPER, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp deep",
                            " ",
                            ChatColor.GRAY + "Collect basic farming resource",
                            ChatColor.GRAY + "from plentiful crops or the local",
                            ChatColor.GRAY + "animal population.",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Farming",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "I",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }

            });
        }else {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                    player1.sendMessage(plugin.getPrefix() + "You need Redstone Collection level 7 to use this.");
                }

                @Override
                public int getSlot() {
                    return 16;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.GREEN + "Deep Caverns" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.BEDROCK, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp deep",
                            " ",
                            ChatColor.GRAY + "An island that gets progressively",
                            ChatColor.GRAY + "deeper and contains 6 layers of",
                            ChatColor.GRAY + "dangerous mobs and new resources.",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Mining",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "II",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }

            });
        }

        //Dwarven Mines

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                Player player1 = (Player) e.getWhoClicked();
                player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                player1.sendMessage(plugin.getPrefix() + "Comming Soon!");
            }

            @Override
            public int getSlot() {
                return 20;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.GREEN + "Dwarven Mines" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.BEDROCK, (short) 0, 1,
                        ChatColor.DARK_GRAY + "/warp dwarves",
                        " ",
                        ChatColor.GRAY + "Discover new ores and minerals and",
                        ChatColor.GRAY + "level up your heart of the",
                        ChatColor.GRAY + "Mountain whilst completing",
                        ChatColor.GRAY + "commissions from the Dwarven King",
                        ChatColor.GRAY + "himself.",
                        " ",
                        ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Mining",
                        ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "III",
                        " ",
                        ChatColor.RED + "Comming Soon!");
            }

        });

        //Crystal Hollows

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                Player player1 = (Player) e.getWhoClicked();
                player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                player1.sendMessage(plugin.getPrefix() + "Comming Soon!");
            }

            @Override
            public int getSlot() {
                return 21;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.GREEN + "Crystal Hollows" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Entrance", Material.BEDROCK, (short) 0, 1,
                        ChatColor.DARK_GRAY + "/warp crystals",
                        " ",
                        ChatColor.GRAY + "A vast series of caves and random",
                        ChatColor.GRAY + "structures with tougher Stone and",
                        ChatColor.GRAY + "special gems!",
                        " ",
                        ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Mining",
                        ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "IV",
                        " ",
                        ChatColor.RED + "Comming Soon!");
            }

        });



        // Spider's Den

        if (user.hasCollection(ItemCollection.GRAVEL, 8)){
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    World spider_mine = Bukkit.getWorld(plugin.getConfig().getString("hub_world"));
                    player1.teleport(new Location(spider_mine, -201 , 84 , -232));
                }

                @Override
                public int getSlot() {
                    return 22;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.GREEN + "Spider's Den" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.PAPER, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp spider",
                            " ",
                            ChatColor.GRAY + "Explore a dangerous nest, discover",
                            ChatColor.GRAY + "the Bestiary, hunt for Relics, and",
                            ChatColor.GRAY + "fight all kinds of Spiders!",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Combat",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "I",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }

            });
        }else {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                    player1.sendMessage(plugin.getPrefix() + "You need Gravel Collection level 8 to use this.");
                }

                @Override
                public int getSlot() {
                    return 22;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.GREEN + "Spider's Den" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.BEDROCK, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp spider",
                            " ",
                            ChatColor.GRAY + "Explore a dangerous nest, discover",
                            ChatColor.GRAY + "the Bestiary, hunt for Relics, and",
                            ChatColor.GRAY + "fight all kinds of Spiders!",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Combat",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "I",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }

            });
        }


        // The End


        if (user.hasCollection(ItemCollection.END_STONE, 8)){
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    World the_end = Bukkit.getWorld(plugin.getConfig().getString("hub_world"));
                    player1.teleport(new Location(the_end, -499 , 101 , -275));
                }

                @Override
                public int getSlot() {
                    return 23;
                }
                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.GREEN + "The End" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.PAPER, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp end",
                            " ",
                            ChatColor.GRAY + "Fight Zealots, mine End Stone, and",
                            ChatColor.GRAY + "defeat ancient Dragons!",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Combat",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "III",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }

            });
        }else {
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                    player1.sendMessage(plugin.getPrefix() + "You need End Stone Collection level 8 to use this.");
                }

                @Override
                public int getSlot() {
                    return 23;
                }
                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.GREEN + "The End" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.BEDROCK, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp end",
                            " ",
                            ChatColor.GRAY + "Fight Zealots, mine End Stone, and",
                            ChatColor.GRAY + "defeat ancient Dragons!",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Combat",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "III",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }

            });
        }


        // Nether

        if (user.hasCollection(ItemCollection.GLOWSTONE_DUST, 4)){
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    World nether = Bukkit.getWorld(plugin.getConfig().getString("hub_world"));
                    player1.teleport(new Location(nether, -310 , 83 , -381));
                }

                @Override
                public int getSlot() {
                    return 24;
                }
                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.GREEN + "Crimson Isle" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.PAPER, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp nether",
                            " ",
                            ChatColor.GRAY + "Fight challenging bosses, discover",
                            ChatColor.GRAY + "new Sea Creatures, complete epic",
                            ChatColor.GRAY + "quests, and join your favourite",
                            ChatColor.GRAY + "faction!",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Combat",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "IV",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }

            });
        }else{
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                    player1.sendMessage(plugin.getPrefix() + "You need Glowstone Dust Collection level 4 to use this.");
                }

                @Override
                public int getSlot() {
                    return 24;
                }
                @Override
                public ItemStack getItem(){
                    return SUtil.getStack(ChatColor.GREEN + "Crimson Isle" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", Material.BEDROCK, (short) 0, 1,
                            ChatColor.DARK_GRAY + "/warp nether",
                            " ",
                            ChatColor.GRAY + "Fight challenging bosses, discover",
                            ChatColor.GRAY + "new Sea Creatures, complete epic",
                            ChatColor.GRAY + "quests, and join your favourite",
                            ChatColor.GRAY + "faction!",
                            " ",
                            ChatColor.GRAY + "Main Skill: " + ChatColor.AQUA + "Combat",
                            ChatColor.GRAY + "Island Tier" + ChatColor.YELLOW + "IV",
                            " ",
                            ChatColor.YELLOW + "Click to warp!");
                }

            });
        }

        // Garden

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                Player player1 = (Player) e.getWhoClicked();
                player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                player1.sendMessage(plugin.getPrefix() + "Comming Soon!");
            }

            @Override
            public int getSlot() {
                return 30;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.GREEN + "Garden", Material.BEDROCK, (short) 0, 1,
                        ChatColor.DARK_GRAY + "/warp garden",
                        " ",
                        ChatColor.GRAY + "Spawn on your very own "+ ChatColor.GREEN + "Garden.",
                        " ",
                        ChatColor.RED + "Comming Soon!");
            }

        });

        // Jerry WorkShop

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                Player player1 = (Player) e.getWhoClicked();
                player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                player1.sendMessage(plugin.getPrefix() + "Comming Soon!");
            }

            @Override
            public int getSlot() {
                return 32;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.AQUA + "Warp to: "+ ChatColor.RED+"Jerry's Workshop", Material.BEDROCK, (short) 0, 1,
                        ChatColor.DARK_GRAY + "Teleports you to "+ChatColor.RED + "Jerry's",
                        ChatColor.RED+"Workshop. "+ ChatColor.GRAY + "Available for a",
                        ChatColor.GRAY + "limited time!",
                        " ",
                        ChatColor.RED + "Comming Soon!");
            }

        });

        //Island Browser

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                Player player1 = (Player) e.getWhoClicked();
                player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                player1.sendMessage(plugin.getPrefix() + "Comming Soon!");
            }

            @Override
            public int getSlot() {
                return 45;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.GREEN + "Island Browser", Material.BLAZE_POWDER, (short) 0, 1,
                        ChatColor.DARK_GRAY + "Check out the most popular",
                        ChatColor.GRAY + "islands in Skyblock! Filter by",
                        ChatColor.GRAY + "category tags to explore various",
                        ChatColor.GRAY+ "types of islands.",
                        " ",
                        ChatColor.RED + "Comming Soon!");
            }

        });

        // Advanced mode

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                Player player1 = (Player) e.getWhoClicked();
                player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                player1.sendMessage(plugin.getPrefix() + "Comming Soon!");
            }

            @Override
            public int getSlot() {
                return 50;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.GREEN + "Advanced Mode", Material.INK_SACK, (short) 10, 1,
                        ChatColor.DARK_GRAY + "Show additional convenient fast",
                        ChatColor.GRAY +"travel options such as quick",
                        ChatColor.GRAY + "Right-Click warping and extra",
                        ChatColor.GRAY + "warps obtained from " + ChatColor.DARK_PURPLE + "EPIC",
                        ChatColor.GRAY + "scrolls",
                        " ",
                        ChatColor.GRAY + "Enabled: " + ChatColor.GREEN + "ON",
                        ChatColor.RED + "Comming Soon!");
            }

        });

        // Paper Icon

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.FAST_TRAVEL.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 53;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.GREEN + "Paper Icon", Material.EMPTY_MAP, (short) 0, 1,
                        ChatColor.DARK_GRAY + "Use paper icons, which may load this",
                        ChatColor.GRAY + "menu faster on your computer.",
                        " ",
                        ChatColor.GRAY + "Enabled: " + ChatColor.GREEN + "ON",
                        ChatColor.YELLOW + "Click to toggle!");
            }

        });
    }
}
