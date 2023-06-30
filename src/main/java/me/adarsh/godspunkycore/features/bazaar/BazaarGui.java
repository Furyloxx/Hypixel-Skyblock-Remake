package me.adarsh.godspunkycore.features.bazaar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class BazaarGui {



    public static void createGui(Player player){
        BazaarCategory.init();
        Inventory inv = Bukkit.createInventory(null , 54 , "Bazaar");
        System.out.println("test 1 pass");
        for (BazaarCategory category : CategoryManger.getCategories()){
            System.out.println("test 2 pass");
            System.out.println(category);
            System.out.println(category.createCategory());
            System.out.println(category.getIcon());
            System.out.println("Test 3 pass");
            inv.addItem(category.createCategory());
            System.out.println("test 4 pass");
        }
        player.openInventory(inv);
    }
}
