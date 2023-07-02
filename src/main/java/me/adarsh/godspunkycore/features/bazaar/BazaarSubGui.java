package me.adarsh.godspunkycore.features.bazaar;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BazaarSubGui {


    public void CreateBazaarSubGui(Player player) {
        Inventory inv = Bukkit.createInventory(null, 36, "Bazaar Sub items");
        fillInventory(inv, new ItemStack(Material.STAINED_GLASS_PANE));
        for (BazaarCategory category : CategoryManger.farmingCategories) {
            addItems(inv, category.createCategory());
        }
        player.openInventory(inv);
    }


    public void fillInventory(Inventory inventory, ItemStack itemStack) {
        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, itemStack);
        }
    }
    public void addItems(Inventory inventory, ItemStack itemStack) {
        //todo
    }
}

