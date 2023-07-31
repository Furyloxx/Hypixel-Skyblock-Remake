package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class EnderChest1 extends GUI {
    public EnderChest1() {
        super("Ender Chest (1/3)", 54);
        fill(BLACK_STAINED_GLASS_PANE, 2, 6);
        set(GUIClickableItem.getCloseItem(0));
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        set(GUIClickableItem.createGUIOpenerItem(GUIType.STORAGE, e.getPlayer(), ChatColor.GREEN + "Go Back", 1, Material.ARROW));
        User user = User.getUser(e.getPlayer().getUniqueId());
        Inventory inventory = e.getInventory();
        for (Map.Entry<SMaterial, Integer> entry : user.getchestpage1().entrySet())
            inventory.addItem(SUtil.setStackAmount(SItem.of(entry.getKey()).getStack(), entry.getValue()));
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.ENDERCHEST2.getGUI().open((Player) e.getWhoClicked());
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

    @Override
    public void onClose(InventoryCloseEvent e) {
        User user = User.getUser(e.getPlayer().getUniqueId());
        Inventory inventory = e.getInventory();
        user.clearChestPageOne();
        for (int i = 9; i < 54; i++) {
            ItemStack stack = inventory.getItem(i);
            SItem sItem = SItem.find(stack);
            if (sItem == null) {
                sItem = SItem.of(stack);
                if (sItem == null)
                    continue;
            }
            user.addToChestPageOne(sItem.getType(), stack.getAmount()); // TODO: SAVE ITEMS IN ALL ENDER CHESTS
        }
        user.save();
    }
}