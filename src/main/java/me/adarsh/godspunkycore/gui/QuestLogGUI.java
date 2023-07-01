package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class QuestLogGUI extends GUI{
    public QuestLogGUI() {
        super("Quest Log", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        fill(BLACK_STAINED_GLASS_PANE);
        Player player = e.getPlayer();

        set(GUIClickableItem.getCloseItem(49));

        // Arrow
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

        // Quest Icon
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {

            }

            @Override
            public int getSlot() {
                return 4;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Personal",Material.BOOK_AND_QUILL, (short) 0,1,
                        ChatColor.GRAY + "View your active quests,",
                        ChatColor.GRAY + "progress, and rewards");
            }
        });


        // Fairy Soul Quest
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
                return SUtil.getSkullURLStack(ChatColor.YELLOW + "Find all Fairy Souls","b96923ad247310007f6ae5d326d847ad53864cf16c3565a181dc8e6b20be2387", 1,
                        "",
                        ChatColor.RED + "   ✖ "+ChatColor.YELLOW+"Found:" + ChatColor.LIGHT_PURPLE + "0" + ChatColor.GRAY + "/" + ChatColor.LIGHT_PURPLE+"238",
                        "",
                        ChatColor.GRAY+"Forever Going Quest...",
                        ChatColor.YELLOW + "Click for details!");
            }
        });
    }
}

