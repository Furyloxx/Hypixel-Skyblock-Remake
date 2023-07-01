package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.collection.ItemCollection;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class FastTravelGUI extends GUI{
    private Skyblock plugin = Skyblock.getPlugin();
    public FastTravelGUI() {
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
                return SUtil.getSkullURLStack(ChatColor.AQUA + "Private Island", "c9c8881e42915a9d29bb61a16fb26d059913204d265df5b439b3d792acd56", 1,
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
                return SUtil.getSkullURLStack(ChatColor.AQUA + "Skyblock Hub", "cf40942f364f6cbceffcf1151796410286a48b1aeba77243e218026c09cd1", 1,
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
                Player player1 = (Player) e.getWhoClicked();
                player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0f);
                player1.sendMessage(plugin.getPrefix() + "Comming Soon!");
            }

            @Override
            public int getSlot() {
                return 12;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.GREEN + "Dungeon Hub " + ChatColor.DARK_GRAY + "- " + ChatColor.AQUA + "Spawn", "1035c528036b384c53c9c8a1a125685e16bfb369c197cc9f03dfa3b835b1aa55", 1,
                        ChatColor.DARK_GRAY + "/warp dungeon_hub",
                        " ",
                        ChatColor.GRAY + "Group with friends and take on",
                        ChatColor.GRAY + "challenging Dungeons.",
                        " ",
                        ChatColor.RED + "Comming Soon!");
            }
        });

        // The Barn TODO: coordinates
        if (user.hasCollection(ItemCollection.POTATO, 6)){
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    World the_barn = Bukkit.getWorld(plugin.getConfig().getString("hub_world"));
                    player1.teleport(new Location(the_barn, -3 , 70 , -68));
                }

                @Override
                public int getSlot() {
                    return 13;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "The Barn" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", "4d3a6bd98ac1833c664c4909ff8d2dc62ce887bdcf3cc5b3848651ae5af6b", 1,
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
                    player1.sendMessage(plugin.getPrefix() + "You need Potato Collection level 6 to use this");
                }

                @Override
                public int getSlot() {
                    return 13;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "The Barn" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", "1035c528036b384c53c9c8a1a125685e16bfb369c197cc9f03dfa3b835b1aa55", 1,
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


        // The Park TODO: coordinates

        if (user.hasCollection(ItemCollection.BIRCH_WOOD, 7)){
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    World park = Bukkit.getWorld(plugin.getConfig().getString("hub_world"));
                    player1.teleport(new Location(park, -3 , 70 , -68));
                }

                @Override
                public int getSlot() {
                    return 14;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "The Park" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", "b76c7f96f862243c5a6fe727aec0b8657cd2c65a463fd816c94efe4c622c055a", 1,
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
                    player1.sendMessage(plugin.getPrefix()+ "You need Birch Wood collection level 7 to use this");
                }

                @Override
                public int getSlot() {
                    return 14;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "The Park" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", "1035c528036b384c53c9c8a1a125685e16bfb369c197cc9f03dfa3b835b1aa55", 1,
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

        // Gold Mine TODO: coordinates

        if (user.hasCollection(ItemCollection.COAL, 6)){
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    World gold_mine = Bukkit.getWorld(plugin.getConfig().getString("hub_world"));
                    player1.teleport(new Location(gold_mine, -3 , 70 , -68));
                }

                @Override
                public int getSlot() {
                    return 15;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "Gold Mine" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", "73bc965d579c3c6039f0a17eb7c2e6faf538c7a5de8e60ec7a719360d0a857a9", 1,
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
                    player1.sendMessage(plugin.getPrefix() + "You need Coal Collection level 6 to use this.");
                }

                @Override
                public int getSlot() {
                    return 15;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "Gold Mine" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", "1035c528036b384c53c9c8a1a125685e16bfb369c197cc9f03dfa3b835b1aa55", 1,
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

        // Deep Caverns TODO: coordinates

        if (user.hasCollection(ItemCollection.REDSTONE, 7)){
            set(new GUIClickableItem() {
                @Override
                public void run(InventoryClickEvent e) {
                    Player player1 = (Player) e.getWhoClicked();
                    World deep_caverns = Bukkit.getWorld(plugin.getConfig().getString("hub_world"));
                    player1.teleport(new Location(deep_caverns, -3 , 70 , -68));
                }

                @Override
                public int getSlot() {
                    return 16;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "Deep Caverns" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", "569a1f114151b4521373f34bc14c2963a5011cdc25a6554c48c708cd96ebfc", 1,
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
                    player1.sendMessage(plugin.getPrefix() + "You need Redstone Collection level 7 to use this.");
                }

                @Override
                public int getSlot() {
                    return 16;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "Deep Caverns" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", "1035c528036b384c53c9c8a1a125685e16bfb369c197cc9f03dfa3b835b1aa55", 1,
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
                return SUtil.getSkullURLStack(ChatColor.GREEN + "Dwarven Mines" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", "1035c528036b384c53c9c8a1a125685e16bfb369c197cc9f03dfa3b835b1aa55", 1,
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
                return SUtil.getSkullURLStack(ChatColor.GREEN + "Crystal Hollows" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Entrance", "1035c528036b384c53c9c8a1a125685e16bfb369c197cc9f03dfa3b835b1aa55", 1,
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
                    player1.teleport(new Location(spider_mine, -3 , 70 , -68));
                }

                @Override
                public int getSlot() {
                    return 22;
                }

                @Override
                public ItemStack getItem(){
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "Spider's Den" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", "21c5840736229db9d9645bf9b409e73e706e3dc4fc30d78eb2079d20d929db9e", 1,
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
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "Spider's Den" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", "1035c528036b384c53c9c8a1a125685e16bfb369c197cc9f03dfa3b835b1aa55", 1,
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
                    player1.teleport(new Location(the_end, -3 , 70 , -68));
                }

                @Override
                public int getSlot() {
                    return 23;
                }
                @Override
                public ItemStack getItem(){
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "The End" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", "7840b87d52271d2a755dedc82877e0ed3df67dcc42ea479ec146176b02779a5", 1,
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
                    return SUtil.getSkullURLStack(ChatColor.GREEN + "The End" + ChatColor.GRAY + " - " + ChatColor.AQUA + "Spawn", "1035c528036b384c53c9c8a1a125685e16bfb369c197cc9f03dfa3b835b1aa55", 1,
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
    }
}
