package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CookieInfoGUI extends GUI {
    public CookieInfoGUI() {
        super("Booster Cookie", 27);
    }
    @Override
    public void onOpen(GUIOpenEvent e) {
        fill(BLACK_STAINED_GLASS_PANE);
        Player player = e.getPlayer();
        User user = User.getUser(e.getPlayer().getUniqueId());
        set(GUIClickableItem.getCloseItem(22));

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.SKYBLOCK_MENU.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 21;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.GREEN + "Go Back", Material.ARROW, (short) 0, 1,
                        ChatColor.GRAY + "To SkyBlock Menu");
            }
        });

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 10;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.GOLD + "Enchantment Table", Material.ENCHANTMENT_TABLE, (short) 0, 1,
                        ChatColor.DARK_GRAY + "/et",
                        " ",
                        ChatColor.GRAY + "Access an Enchantment Table from",
                        ChatColor.GRAY + "anywhere in SkyBlock.",
                        " ",
                        ChatColor.GRAY + "This portable table remembers",
                        ChatColor.GRAY + "the highest " + ChatColor.LIGHT_PURPLE + "Bookshelf Power",
                        ChatColor.GRAY + "you've seen!",
                        " ",
                        ChatColor.YELLOW + "Click to check it out!");
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
                return SUtil.getStack(ChatColor.GOLD + "Anvil", Material.ANVIL, (short) 0, 1,
                        ChatColor.DARK_GRAY + "/av",
                        " ",
                        ChatColor.GRAY + "Access an Anvil from anywhere in",
                        ChatColor.GRAY + "SkyBlock.",
                        " ",
                        ChatColor.YELLOW + "Click to check it out!");
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
            public ItemStack getItem(){
                return SUtil.getSkullURLStack(ChatColor.AQUA + "Bazaar", "79195a3343935ff05d103feded5d509e55d0c6c7182a8b0c097a31c5439192f2", 1,
                        ChatColor.DARK_GRAY + "/bz",
                        " ",
                        ChatColor.GRAY + "Access an Bazaar from anywhere",
                        ChatColor.GRAY + "in SkyBlock.",
                        " ",
                        ChatColor.YELLOW + "Click to check it out!");
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
            public ItemStack getItem(){
                return SUtil.getSkullStack(ChatColor.GREEN + "Auction house", player.getName(), 1,
                        ChatColor.DARK_GRAY + "/ah",
                        " ",
                        ChatColor.GRAY + "Access an Auction House Menu",
                        ChatColor.GRAY + "from anywhere in SkyBlock.",
                        " ",
                        ChatColor.YELLOW + "Click to check it out!");
            }
        });
    }
}
