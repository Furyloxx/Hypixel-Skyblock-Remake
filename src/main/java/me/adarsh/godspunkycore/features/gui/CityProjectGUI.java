package me.adarsh.godspunkycore.features.gui;

import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CityProjectGUI extends GUI {
    public CityProjectGUI() {
        super("Community Shop", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        fill(BLACK_STAINED_GLASS_PANE);
        Player player = e.getPlayer();
        User user = User.getUser(player.getUniqueId());

        // city project
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 1;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "City Project", Material.GOLD_BARDING, (short) 0, 1,
                        ChatColor.GRAY + "Participate with the whole",
                        ChatColor.GRAY + "SkyBlock community to upgrade",
                        ChatColor.GRAY + "the village and more.",
                        " ",
                        ChatColor.AQUA + "Contribute " + ChatColor.GRAY + "to various",
                        ChatColor.GRAY + "project to obtain unique",
                        ChatColor.GRAY + "perks.",
                        "",
                        ChatColor.GREEN + "Currently Selected!");
            }
        });

        // Account & Profile Upgrade
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 2;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.LIGHT_PURPLE + "Account & Profile Upgrades", Material.HOPPER, (short) 0, 1,
                        ChatColor.GRAY + "Upgrade your current profile and",
                        ChatColor.GRAY + "your SkyBlock account with",
                        ChatColor.GRAY + "permanent upgrades.",
                        " ",
                        ChatColor.GRAY + "Profile: " + ChatColor.DARK_GRAY + "Nothing going on!",
                        ChatColor.GRAY + "Account:" + ChatColor.DARK_GRAY + "None underway!",
                        "",
                        ChatColor.YELLOW + "Click to view!");
            }
        });

        // Booster Cookie
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.BOOSTER_COOKIE_SHOP.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 3;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GOLD + "Booster Cookie", Material.COOKIE, (short) 0, 1,
                        ChatColor.GRAY + "Obtain a temporary buff",
                        ChatColor.GRAY + "letting you earn " + ChatColor.AQUA + "bits",
                        ChatColor.GRAY + "as well as " + ChatColor.LIGHT_PURPLE + "tons of perks.",
                        " ",
                        ChatColor.YELLOW + "Click to view!");
            }
        });

        // Bits Shop
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.BIT_SHOP.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 4;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.AQUA + "Bits Shop", Material.DIAMOND, (short) 0, 1,
                        ChatColor.GRAY + "Spend" + ChatColor.AQUA + "bits" + ChatColor.GRAY + "on a variety of",
                        ChatColor.GRAY + "powerful items.",
                        "",
                        ChatColor.GRAY + "Earn bits from " + ChatColor.GOLD + "Booster Cookie.",
                        " ",
                        ChatColor.YELLOW + "Click to view!");
            }
        });

        // Fire Sale
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.FIRE_SALE.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 5;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.translateAlternateColorCodes('&',"&6♨ &c&lFIRE &cSales &6♨"), Material.BLAZE_POWDER, (short) 0, 1,
                        ChatColor.GRAY + "Acquire " + ChatColor.GOLD + "exclusive" + ChatColor.GRAY + "cosmetics",
                        ChatColor.GRAY + "which are only available in",
                        ChatColor.RED + "limited quantity" + ChatColor.GRAY + " across all",
                        ChatColor.GRAY + "of SkyBlock",
                        " ",
                        ChatColor.DARK_GRAY + "No ongoing sale!",
                        "",
                        ChatColor.YELLOW + "Click to view!");
            }
        });

        // Rank
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 7;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "GodSpunky Ranks", Material.EMERALD, (short) 0, 1,
                        ChatColor.GRAY + "Browse the SkyBlock perks of" ,
                        ChatColor.GRAY + "our " + ChatColor.YELLOW + "server-wide" + ChatColor.GRAY + "ranks such",
                        ChatColor.GRAY + "as the " + ChatColor.GOLD+"[MVP"+ChatColor.RED+"++"+ChatColor.GOLD+"]"+ChatColor.GRAY+" rank.",
                        ChatColor.GRAY + "of SkyBlock",
                        " ",
                        ChatColor.YELLOW + "Click to view!");
            }
        });

        // Gray Glass
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 12;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.DARK_GRAY + "▲ " +ChatColor.GRAY+"Categories", Material.STAINED_GLASS_PANE, (short) 7, 1,
                        ChatColor.DARK_GRAY + "▼ " +ChatColor.GRAY+"Items");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 11;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.DARK_GRAY + "▲ " +ChatColor.GRAY+"Categories", Material.STAINED_GLASS_PANE, (short) 7, 1,
                        ChatColor.DARK_GRAY + "▼ " +ChatColor.GRAY+"Items");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 13;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.DARK_GRAY + "▲ " +ChatColor.GRAY+"Categories", Material.STAINED_GLASS_PANE, (short) 7, 1,
                        ChatColor.DARK_GRAY + "▼ " +ChatColor.GRAY+"Items");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 14;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.DARK_GRAY + "▲ " +ChatColor.GRAY+"Categories", Material.STAINED_GLASS_PANE, (short) 7, 1,
                        ChatColor.DARK_GRAY + "▼ " +ChatColor.GRAY+"Items");
            }
        });
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 16;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.DARK_GRAY + "▲ " +ChatColor.GRAY+"Categories", Material.STAINED_GLASS_PANE, (short) 7, 1,
                        ChatColor.DARK_GRAY + "▼ " +ChatColor.GRAY+"Items");
            }
        });

        //Lime Glass
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 10;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.DARK_GRAY + "▲ " +ChatColor.GRAY+"Categories", Material.STAINED_GLASS_PANE, (short) 5, 1,
                        ChatColor.DARK_GRAY + "▼ " +ChatColor.GRAY+"Items");
            }
        });

        // Project
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                player.sendMessage(ChatColor.RED+"Coming Soon!");
                player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT,1.0f,1.0f);
            }

            @Override
            public int getSlot() {
                return 31;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.RED + "Coming Soon!", Material.BEDROCK, (short) 0, 1,
                        "");
            }
        });


        // Link
        set(new GUIClickableItem() {
            String bits = PlaceholderAPI.setPlaceholders(player, "%royaleeconomy_balance_purse%");
            @Override
            public void run(InventoryClickEvent e) {
                player.sendMessage(ChatColor.AQUA+"https://godspunky.store/");
            }

            @Override
            public int getSlot() {
                return 49;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Community Shop", Material.EMERALD, (short) 0, 1,
                        "",
                        ChatColor.DARK_GRAY + "Elizabeth",
                        "",
                        ChatColor.translateAlternateColorCodes('&',"&7Gems: "),
                        ChatColor.translateAlternateColorCodes('&',"&8Purchase on godspunky.store"),
                        " ",
                        ChatColor.translateAlternateColorCodes('&',"&7Bits: " + ChatColor.AQUA+bits),
                        ChatColor.translateAlternateColorCodes('&',"&8Earn from Booster Cookies!"),
                        "",
                        ChatColor.translateAlternateColorCodes('&',"&7Fame Rank: &eNew player"),
                        ChatColor.translateAlternateColorCodes('&',"&8rank up by spending gems &"),
                        ChatColor.translateAlternateColorCodes('&',"&8bits!"),
                        "",
                        ChatColor.GRAY+"Store: "+ChatColor.AQUA+"godspunky.store",
                        ChatColor.YELLOW+"Click to get link!");
            }
        });

        // Previous Projects
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 50;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Previous Project", Material.BOOKSHELF, (short) 0, 1,
                        ChatColor.translateAlternateColorCodes('&',"&7The community completed &e0"),
                        ChatColor.translateAlternateColorCodes('&',"&7projects in the past."),
                        "",
                        ChatColor.YELLOW+"Click to view them!");
            }
        });

    }
}

