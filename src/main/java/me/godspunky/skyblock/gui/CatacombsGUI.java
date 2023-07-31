package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.features.Dungeon.DungeonGenerator;
import me.godspunky.skyblock.user.PlayerStatistics;
import me.godspunky.skyblock.user.PlayerUtils;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.Sputnik;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CatacombsGUI extends GUI {
    public CatacombsGUI() {
        super("Catacombs Gate", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {

        fill(BLACK_STAINED_GLASS_PANE);

        Player player1 = e.getPlayer();

        User user = User.getUser(player1.getUniqueId());
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player1.getUniqueId());
        set(GUIClickableItem.getCloseItem(49));
        DungeonGenerator generator = new DungeonGenerator();

        // 1
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {};

            @Override
            public int getSlot() {
                return 11;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.translateAlternateColorCodes('&', "&aThe Catacombs &7- &eThe Entrance"), "5901637d9166e0ec0f30618a5262ae02748bc59abaddf31a7151ebbd86124a57", 1,
                        ChatColor.GRAY + "Dungeon Size: "+ChatColor.AQUA+"Tiny",
                        ChatColor.GRAY + "Party Size: "+ChatColor.BLUE+"2-5",
                        "",
                        ChatColor.translateAlternateColorCodes('&',"&7Mini-Boss: &cThe Watcher &a✔"),
                        ChatColor.DARK_GRAY+"Stalker",
                        ChatColor.GRAY+"This strange creature is roaming the",
                        ChatColor.GRAY+"catacombs to add powerful  adventurers to",
                        ChatColor.GRAY+"its collection",
                        "",
                        ChatColor.GRAY+"Requires: "+ChatColor.AQUA+"Combat Level XV",
                        "",
                        ChatColor.YELLOW + "Click to queue for dungeon!");
            }
        });

        //2
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                player1.closeInventory();
                player1.playSound(player1.getLocation(), Sound.CREEPER_HISS,1.0f,1.0f);
                Sputnik.startRoom(player1);
            }

            @Override
            public int getSlot() {
                return 12;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.translateAlternateColorCodes('&', "&aThe Catacombs &7- &eFloor I"), "5901637d9166e0ec0f30618a5262ae02748bc59abaddf31a7151ebbd86124a57", 1,
                        ChatColor.GRAY + "Dungeon Size: "+ChatColor.AQUA+"Tiny",
                        ChatColor.GRAY + "Party Size: "+ChatColor.BLUE+"2-5",
                        "",
                        ChatColor.translateAlternateColorCodes('&',"&7Boss: &cBonzo &a✔"),
                        ChatColor.DARK_GRAY+"New necromancer",
                        ChatColor.GRAY+"Involved in the dark arts due to his",
                        ChatColor.GRAY+"parent's insistence. Originally worked as",
                        ChatColor.GRAY+"a Circus Clown",
                        "",
                        ChatColor.GRAY+"Requires: "+ChatColor.LIGHT_PURPLE+"Catacombs Level I",
                        "",
                        ChatColor.YELLOW + "Click to queue for dungeon!");
            }
        });

        //3
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 13;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.translateAlternateColorCodes('&', "&aThe Catacombs &7- &eFloor II"), "5901637d9166e0ec0f30618a5262ae02748bc59abaddf31a7151ebbd86124a57", 1,
                        ChatColor.GRAY + "Dungeon Size: "+ChatColor.AQUA+"Small",
                        ChatColor.GRAY + "Party Size: "+ChatColor.BLUE+"2-5",
                        "",
                        ChatColor.translateAlternateColorCodes('&',"&7Boss: &cScarf &a✔"),
                        ChatColor.DARK_GRAY+"Apprentice necromancer",
                        ChatColor.GRAY+"First of his class. His teacher said he",
                        ChatColor.GRAY+"will do 'great things'.",
                        "",
                        ChatColor.GRAY+"Requires: "+ChatColor.LIGHT_PURPLE+"Catacombs Level III",
                        "",
                        ChatColor.YELLOW + "Click to queue for dungeon!");
            }
        });

        //4
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 14;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.translateAlternateColorCodes('&', "&aThe Catacombs &7- &eFloor III"), "5901637d9166e0ec0f30618a5262ae02748bc59abaddf31a7151ebbd86124a57", 1,
                        ChatColor.GRAY + "Dungeon Size: "+ChatColor.AQUA+"Small",
                        ChatColor.GRAY + "Party Size: "+ChatColor.BLUE+"2-5",
                        "",
                        ChatColor.translateAlternateColorCodes('&',"&7Boss: &cThe Professor &a✔"),
                        ChatColor.DARK_GRAY+"Professor",
                        ChatColor.GRAY+"Despite his great technique, he failed",
                        ChatColor.GRAY+"the Masters exam three times. Works from 8",
                        ChatColor.GRAY+"to 5. Cares about his students",
                        "",
                        ChatColor.GRAY+"Requires: "+ChatColor.LIGHT_PURPLE+"Catacombs Level V",
                        "",
                        ChatColor.YELLOW + "Click to queue for dungeon!");
            }
        });

        //5
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 15;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.translateAlternateColorCodes('&', "&aThe Catacombs &7- &eFloor IV"), "5901637d9166e0ec0f30618a5262ae02748bc59abaddf31a7151ebbd86124a57", 1,
                        ChatColor.GRAY + "Dungeon Size: "+ChatColor.AQUA+"Small",
                        ChatColor.GRAY + "Party Size: "+ChatColor.BLUE+"2-5",
                        "",
                        ChatColor.translateAlternateColorCodes('&',"&7Boss: &cThorn &a✔"),
                        ChatColor.DARK_GRAY+"Shaman Necromancer",
                        ChatColor.GRAY+"Powerful Necromancer that specializes in",
                        ChatColor.GRAY+"animals. Calls himself a vegetarian, go",
                        ChatColor.GRAY+"figure.",
                        "",
                        ChatColor.GRAY+"Requires: "+ChatColor.LIGHT_PURPLE+"Catacombs Level Ix",
                        "",
                        ChatColor.YELLOW + "Click to queue for dungeon!");
            }
        });

        //6
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 21;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.translateAlternateColorCodes('&', "&aThe Catacombs &7- &eFloor V"), "5901637d9166e0ec0f30618a5262ae02748bc59abaddf31a7151ebbd86124a57", 1,
                        ChatColor.GRAY + "Dungeon Size: "+ChatColor.AQUA+"Medium",
                        ChatColor.GRAY + "Party Size: "+ChatColor.BLUE+"2-5",
                        "",
                        ChatColor.translateAlternateColorCodes('&',"&7Boss: &cLivid &a✔"),
                        ChatColor.DARK_GRAY+"Master Necromancer",
                        ChatColor.GRAY+"Strongly believes he will become the",
                        ChatColor.GRAY+"Lord one day. Subject of mockeries, even",
                        ChatColor.GRAY+"from his disciples",
                        "",
                        ChatColor.GRAY+"Requires: "+ChatColor.LIGHT_PURPLE+"Catacombs Level XIV",
                        "",
                        ChatColor.YELLOW + "Click to queue for dungeon!");
            }
        });

        //7
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 22;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.translateAlternateColorCodes('&', "&aThe Catacombs &7- &eFloor VI"), "5901637d9166e0ec0f30618a5262ae02748bc59abaddf31a7151ebbd86124a57", 1,
                        ChatColor.GRAY + "Dungeon Size: "+ChatColor.AQUA+"Medium",
                        ChatColor.GRAY + "Party Size: "+ChatColor.BLUE+"2-5",
                        "",
                        ChatColor.translateAlternateColorCodes('&',"&7Boss: &cSadan &a✔"),
                        ChatColor.DARK_GRAY+"Necromancer Lord",
                        ChatColor.GRAY+"Necromancy was always strong in his",
                        ChatColor.GRAY+"family. Says he once beat a Wither in a",
                        ChatColor.GRAY+"duel. Likes to brag",
                        "",
                        ChatColor.GRAY+"Requires: "+ChatColor.LIGHT_PURPLE+"Catacombs Level XIX",
                        "",
                        ChatColor.YELLOW + "Click to queue for dungeon!");
            }
        });

        //8
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 23;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.translateAlternateColorCodes('&', "&aThe Catacombs &7- &eFloor VII"), "5901637d9166e0ec0f30618a5262ae02748bc59abaddf31a7151ebbd86124a57", 1,
                        ChatColor.GRAY + "Dungeon Size: "+ChatColor.AQUA+"Medium",
                        ChatColor.GRAY + "Party Size: "+ChatColor.BLUE+"2-5",
                        "",
                        ChatColor.translateAlternateColorCodes('&',"&7Boss: &cMaxor, Storm, Goldor, Necron &a✔"),
                        ChatColor.DARK_GRAY+"The Wither Lords",
                        ChatColor.GRAY+"Disciples of the Wither King. Inherited",
                        ChatColor.GRAY+"the Catacombs eons ago. Never defeated,",
                        ChatColor.GRAY+"feared by anything living AND dead",
                        "",
                        ChatColor.GRAY+"Requires: "+ChatColor.LIGHT_PURPLE+"Catacombs Level XXIV",
                        "",
                        ChatColor.YELLOW + "Click to queue for dungeon!");
            }
        });

        //MASTER
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 40;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.RED+"Master Mode", "cb852ba1584da9e5714859995451e4b94748c4dd63ae4543c15f9f8aec65c8", 1,
                        ChatColor.DARK_GRAY+"Like normal Dungeons... but",
                        ChatColor.DARK_GRAY+"more hardcore",
                        "",
                        ChatColor.RED + "Coming Soon!");
            }
        });

        //Party
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 48;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN+"Find a Party", Material.REDSTONE_BLOCK,(short) 0, 1,
                        ChatColor.GRAY+"Use the Party Finder to join a",
                        ChatColor.GRAY+"party queued for the dungeon.",
                        "",
                        ChatColor.YELLOW + "Click to browse!");
            }
        });

        //Profile
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 50;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN+"Catacombs Profile", Material.SIGN,(short) 0, 1,
                        ChatColor.GRAY+"View your statistics, best",
                        ChatColor.GRAY+"performance, and more for "+ChatColor.RED+"The",
                        ChatColor.RED+"Catacombs"+ChatColor.GRAY+"!",
                        "",
                        ChatColor.RED + "Coming Soon!");
            }
        });

        // Rules
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.CATACOMB_RULE.getGUI().open(player1);
            }

            @Override
            public int getSlot() {
                return 53;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN+"Dungeon Rules and Tips", Material.SIGN,(short) 0, 1,
                        ChatColor.GRAY+"SkyBlock Dungeons has special",
                        ChatColor.GRAY+"rules! Some things inside",
                        ChatColor.GRAY+"Dungeons work differently than",
                        ChatColor.GRAY+"they do in regular SkyBlock.",
                        ChatColor.GRAY+"This menu describes the list of",
                        ChatColor.GRAY+"changes!",
                        "",
                        ChatColor.YELLOW + "Click to view!");
            }
        });
    }
}
