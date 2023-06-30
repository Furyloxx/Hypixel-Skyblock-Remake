package me.adarsh.godspunkycore.features.bazaar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class bazaarGui {



    public static void createGui(Player player){
        BazaarCategory.init();
        Inventory inv = Bukkit.createInventory(null , 54 , "Bazaar");
        categoryManger manger = new categoryManger();
        for (BazaarCategory category : manger.getCategories()){
            System.out.println(category);
            System.out.println(category.createCategory());
            System.out.println(category.getIcon());
            inv.addItem(category.createCategory());
        }
        player.openInventory(inv);
    }
}
