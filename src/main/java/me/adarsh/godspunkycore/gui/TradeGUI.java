package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.features.collection.ItemCollection;
import me.adarsh.godspunkycore.features.item.armor.batperson.BatpersonLeggings;
import me.adarsh.godspunkycore.features.item.mining.Coal;
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

        // COAL
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {

                // TODO : MAKE IT FOR SB ITEMS {IT WORKS FOR VANILLA ONLY}
                if (player.getInventory().contains(Material.LOG,1)){
                    player.getInventory().removeItem(new ItemStack(Material.LOG));
                    player.getInventory().addItem(new ItemStack(Material.COAL,2));
                    player.sendMessage(ChatColor.GRAY+"["+ChatColor.GREEN+"+"+ChatColor.GRAY+"] 2x Coal");
                }else{
                    player.sendMessage(ChatColor.RED+"You don't have required items.");
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
                        ChatColor.WHITE + "" +ChatColor.BOLD + "COMMON",
                        "",
                        ChatColor.GRAY +"Cost",
                        ChatColor.WHITE + "Oak Wood",
                        "",
                        ChatColor.YELLOW + "Click to trade!");
                }
            });
        }
}


