package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class EnderChest2 extends GUI {
    public EnderChest2() {
        super("Ender Chest (2/3)", 54);
        fill(BLACK_STAINED_GLASS_PANE, 2, 4);
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
                return 5;
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
                GUIType.ENDERCHEST1.getGUI().open((Player) e.getWhoClicked());
                ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.CHEST_OPEN,1.0f,1.0f);
            }

            @Override
            public int getSlot() {
                return 6;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.GREEN + "← Previous Page","e5da4847272582265bdaca367237c96122b139f4e597fbc6667d3fb75fea7cf6", 1,
                        " ");
            }
        });

        // NEXT PAGE
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.ENDERCHEST3.getGUI().open((Player) e.getWhoClicked());
                ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.CHEST_OPEN,1.0f,1.0f);
            }

            @Override
            public int getSlot() {
                return 7;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.GREEN + "Next Page →","6527ebae9f153154a7ed49c88c02b5a9a9ca7cb1618d9914a3d9df8ccb3c84", 1,
                        " ");
            }
        });

        // LAST PAGE
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.ENDERCHEST3.getGUI().open((Player) e.getWhoClicked());
                ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.CHEST_OPEN,1.0f,1.0f);
            }

            @Override
            public int getSlot() {
                return 8;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.YELLOW + "Last Page >>","5a92ad456f76ec7caa3595922d5fcc38dca928dc6715f752e74c8ddde344e", 1,
                        " ");
            }
        });
    }
}