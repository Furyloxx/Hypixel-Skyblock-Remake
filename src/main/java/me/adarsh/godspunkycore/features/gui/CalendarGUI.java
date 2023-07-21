package me.adarsh.godspunkycore.features.gui;

import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CalendarGUI extends GUI {
    public CalendarGUI() {
        super("Calendar And Events", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {

        fill(BLACK_STAINED_GLASS_PANE, 0, 9);
        fill(BLACK_STAINED_GLASS_PANE, 17, 18);
        fill(BLACK_STAINED_GLASS_PANE, 26, 27);
        fill(BLACK_STAINED_GLASS_PANE, 35, 53);

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
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Go Back", Material.ARROW, (short) 0, 1,
                        ChatColor.GRAY + "To SkyBlock Menu");
            }
        });

        // Event Reward
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 45;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Event Reward", Material.GOLD_BLOCK, (short) 0, 1,
                        ChatColor.GRAY + "View and claim rewards obtained",
                        ChatColor.GRAY + "through participating in Events",
                        "",
                        ChatColor.RED + "Coming Soon!");
            }
        });

        // Full calendar
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 50;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Calendar", Material.WATCH, (short) 0, 1,
                        ChatColor.GRAY + "Open the full SkyBlock",
                        ChatColor.GRAY + "calendar.",
                        "",
                        ChatColor.RED + "Coming Soon!");
            }
        });
    }
}

