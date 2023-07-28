package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class PotionBagGui extends GUI {
    public PotionBagGui() {
        super("Potions Bag", 18);
        fill(BLACK_STAINED_GLASS_PANE, 9, 17);
        set(GUIClickableItem.getCloseItem(13));
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        set(GUIClickableItem.createGUIOpenerItem(GUIType.SKYBLOCK_MENU, e.getPlayer(), ChatColor.GREEN + "Go Back", 12, Material.ARROW));
        User user = User.getUser(e.getPlayer().getUniqueId());
        Inventory inventory = e.getInventory();
        for (Map.Entry<SMaterial, Integer> entry : user.getPotionbag().entrySet())
            inventory.addItem(SUtil.setStackAmount(SItem.of(entry.getKey()).getStack(), entry.getValue()));
    }

    @Override
    public void onClose(InventoryCloseEvent e) {
        User user = User.getUser(e.getPlayer().getUniqueId());
        Inventory inventory = e.getInventory();
        user.clearPotionBag();
        for (int i = 0; i < 9; i++) {
            ItemStack stack = inventory.getItem(i);
            SItem sItem = SItem.find(stack);
            if (sItem == null) {
                sItem = SItem.of(stack);
                if (sItem == null)
                    continue;
            }
            user.addToPotionbag(sItem.getType(), stack.getAmount());
        }
        user.save();
    }
}