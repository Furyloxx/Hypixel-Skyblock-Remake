package me.adarsh.godspunkycore.features.bazaar;

import me.adarsh.godspunkycore.enums.Category;
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


    public void createGui(Player player, Category enumcategory) {

            Inventory inv = Bukkit.createInventory(null, 54, "Bazaar");
            ItemStack pane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
            fillInventory(inv, pane);
            inv.setItem(0, new ItemStack(Material.GOLD_HOE));
            inv.setItem(1, pane);
            inv.setItem(9, new ItemStack(Material.DIAMOND_PICKAXE));
            inv.setItem(10, pane);
            inv.setItem(9 * 2, new ItemStack(Material.IRON_SWORD));
            inv.setItem(9 * 2 + 1, pane);
            inv.setItem(9 * 3, new ItemStack(Material.FISHING_ROD)); // pov : when you are lazy to count slots
            inv.setItem(9 * 3 + 1, pane);
            inv.setItem(9 * 4, new ItemStack(Material.ENCHANTMENT_TABLE));
            inv.setItem(9 * 4 + 1, pane);
            inv.setItem(9 * 5, new ItemStack(Material.SIGN));
            inv.setItem(9 * 5 + 1, pane);
        if (enumcategory == Category.FarmingCategory) {
            for (BazaarCategory category : CategoryManger.getFarmingCategories()) {
              addItemToInventory(inv , category.createCategory());
                System.out.println(CategoryManger.farmingCategories.size());
            }
        }if (enumcategory == Category.MiningCategory) {
            for (BazaarCategory category : CategoryManger.getMiningCategories()) {
               addItemToInventory(inv , category.createCategory());
                System.out.println(CategoryManger.MiningCategories.size());

            }
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

    public static void addItemToInventory(Inventory inventory, ItemStack itemStack) {
        int size = inventory.getSize();


        for (int i = 0; i < size; i++) {
            ItemStack slotItem = inventory.getItem(i);


            if (slotItem == null || slotItem.getType() == Material.AIR) {
                inventory.setItem(i, itemStack);
                return;
            }
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (!e.getInventory().getName().contains("Bazaar")) return;
        System.out.println("opened inventory"); //debugging frr
        e.setCancelled(true);
        Player player = (Player) e.getWhoClicked();
        if (e.getCurrentItem().equals(new ItemStack(Material.DIAMOND_PICKAXE))){

            createGui(player , Category.MiningCategory);
        }if (e.getCurrentItem().equals(new ItemStack(Material.GOLD_HOE))){
            createGui(player , Category.FarmingCategory);
        }

    }
    @EventHandler
    public void onClose(InventoryCloseEvent e){
        if (!e.getInventory().getName().contains("Bazaar")) return;
        Player player = (Player) e.getPlayer();
        e.getInventory().clear();

        System.out.println("closed inventory");

    }
}
