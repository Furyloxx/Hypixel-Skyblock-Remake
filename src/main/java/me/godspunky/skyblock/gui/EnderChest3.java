package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EnderChest3 extends GUI {
    public EnderChest3() {
        super("Ender Chest (3/3)", 18);
        fill(BLACK_STAINED_GLASS_PANE, 2, 6);
        set(GUIClickableItem.getCloseItem(0));
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        set(GUIClickableItem.createGUIOpenerItem(GUIType.STORAGE, e.getPlayer(), ChatColor.GREEN + "Go Back", 1, Material.ARROW));
        User user = User.getUser(e.getPlayer().getUniqueId());
        Inventory inventory = e.getInventory();

        // FIRST PAGE
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.ENDERCHEST1.getGUI().open((Player) e.getWhoClicked());
                ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.CHEST_OPEN,1.0f,1.0f);
            }

            @Override
            public int getSlot() {
                return 7;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.YELLOW + "<< First Page","dfa605e25f4fc2cea5a766d79a8bfa290313e45d8f5e957d958a0f33fcb16", 1,
                        " ");
            }
        });

        // PREVIOUS PAGE
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.ENDERCHEST2.getGUI().open((Player) e.getWhoClicked());
                ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.CHEST_OPEN,1.0f,1.0f);
            }

            @Override
            public int getSlot() {
                return 8;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.GREEN + "← Previous Page","e5da4847272582265bdaca367237c96122b139f4e597fbc6667d3fb75fea7cf6", 1,
                        " ");
            }
        });
    }
}
