package me.adarsh.godspunkycore.features.bazaar;

import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Array;

public class BazaarSubGui {


    public void CreateBazaarSubGui(Player player) {
        Inventory inv = Bukkit.createInventory(null, 36, "Bazaar Sub items");
        fillInventory(inv, new ItemStack(Material.STAINED_GLASS_PANE));
        for (BazaarCategory category : CategoryManger.farmingCategories) {
            for (SMaterial material : category.getItems()) {
                try {
                    addToInventory(inv, SItem.of(material).getStack());
                }catch (NullPointerException ex){
                    System.out.println("not able to load" + material.getBaseName());
                }
            }
        }
        player.openInventory(inv);
    }


    public void fillInventory(Inventory inventory, ItemStack itemStack) {
        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, itemStack);
        }
    }

    public void addToInventory(Inventory inventory, ItemStack item) {
        int[] slots = {3, 5, 7, 9, 11};
        for (int slot : slots) {
            if (inventory.getItem(slot).equals(new ItemStack(Material.STAINED_GLASS_PANE))) {
                inventory.setItem(slot, item);
                break;
            }
        }
    }
}

