package me.adarsh.godspunkycore.features.bazaar;

import me.adarsh.godspunkycore.features.item.SMaterial;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BazaarGui implements Listener {

    public static void createGui(Player player){
        BazaarCategory.init();
        Inventory inv = Bukkit.createInventory(null , 54 , "Bazaar");
        inv.clear();
        ItemStack pane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
        fillInventory(inv,pane);
        inv.setItem(0 , new ItemStack(Material.GOLD_HOE));
        inv.setItem(1 , pane);
        inv.setItem(9, new ItemStack(Material.DIAMOND_PICKAXE));
        inv.setItem(10 , pane);
        inv.setItem(9 * 2, new ItemStack(Material.IRON_SWORD));
        inv.setItem(9 * 2 + 1 , pane);
        inv.setItem(9 * 3 , new ItemStack(Material.FISHING_ROD)); // pov : when you are lazy to count slots
        inv.setItem(9 * 3 + 1 , pane);
        inv.setItem(9 * 4,new ItemStack(Material.ENCHANTMENT_TABLE));
        inv.setItem(9 * 4 + 1 , pane);
        inv.setItem(9 * 5 , new ItemStack(Material.SIGN));
        inv.setItem(9 * 5 + 1 , pane);


        for (BazaarCategory category : CategoryManger.getFarmingCategories()){
            inv.addItem(category.createCategory());
        }
        player.openInventory(inv);
    }
    public static void fillInventory(Inventory inventory, ItemStack itemStack) {
        int size = inventory.getSize();
        int rows = size / 9;
        // fill right side
        for (int i = 8; i < size; i += 9) {
            inventory.setItem(i, itemStack);
        }
        // fill upper side
        for (int i = 0; i < 9; i++) {
            inventory.setItem(i, itemStack);
        }

        // fill down side
        for (int i = size - 9; i < size; i++) {
            inventory.setItem(i, itemStack);
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (!e.getInventory().getTitle().equals("Bazaar")) return;
        System.out.println("opened inventory"); //debugging frr

    }
    @EventHandler
    public void onClose(InventoryCloseEvent e){
        if (!e.getInventory().getTitle().equals("Bazaar")) return;
        System.out.println("closed inventory");

    }
}
