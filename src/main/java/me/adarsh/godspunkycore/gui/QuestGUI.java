package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class QuestGUI extends GUI {
    public QuestGUI() {
        super("Quest", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {

        fill(BLACK_STAINED_GLASS_PANE, 0, 9);
        fill(BLACK_STAINED_GLASS_PANE, 17, 18);
        fill(BLACK_STAINED_GLASS_PANE, 26, 27);
        fill(BLACK_STAINED_GLASS_PANE, 35, 36);
        fill(BLACK_STAINED_GLASS_PANE, 44, 53);

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

        // Info
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 4;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Quest", Material.BOOK_AND_QUILL, (short) 0, 1,
                        ChatColor.GRAY + "View your active quests,",
                        ChatColor.GRAY + "progress, and rewards");
            }
        });

        // Fairy Soul
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 10;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.YELLOW + "Find all Fairy Souls", "b96923ad247310007f6ae5d326d847ad53864cf16c3565a181dc8e6b20be2387", 1,
                        "",
                        ChatColor.RED + "   ✖ " + ChatColor.LIGHT_PURPLE + "0"+ChatColor.GRAY+"/"+ChatColor.LIGHT_PURPLE+"238",
                        "",
                        ChatColor.GRAY+ "Forever ongoing Quest...",
                        "",
                        ChatColor.YELLOW + "Click to get details!");
            }
        });
    }
}
