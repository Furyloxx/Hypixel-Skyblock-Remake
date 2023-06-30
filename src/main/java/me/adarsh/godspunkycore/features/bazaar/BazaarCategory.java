package me.adarsh.godspunkycore.features.bazaar;

import me.adarsh.godspunkycore.features.item.SMaterial;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BazaarCategory {

    ItemStack icon;
    String name;
    ArrayList<SMaterial> items = new ArrayList<>();
    boolean isEnchanted = false;

    public boolean isEnchanted() {
        return isEnchanted;
    }

    public void setEnchanted(boolean enchanted) {
        isEnchanted = enchanted;
    }

    public BazaarCategory(ItemStack icon , String name , ArrayList<SMaterial> items){
        this.icon = icon;
        this.name = name;
        this.items = items;
    }
    public BazaarCategory(ItemStack icon , String name , ArrayList<SMaterial> items , boolean isEnchanted){
        this.icon = icon;
        this.name = name;
        this.items = items;
        this.isEnchanted = isEnchanted;

    }

    public String getName(){
        return name;
    }

    public ItemStack getIcon() {
        return icon;
    }

    public ArrayList<SMaterial> getItems() {
        return items;
    }

    public void setIcon(ItemStack icon) {
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(ArrayList<SMaterial> items) {
        this.items = items;
    }

    public ItemStack createCategory(){
        ItemStack stack = new ItemStack(icon.getType());
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + name);
        ArrayList<String> lore = new ArrayList<>();
        lore.add(items.size() + " products");
        lore.add("");
        lore.add("Buy price: " + 0.0 + ChatColor.GOLD + " Coins" );
        lore.add("Sell price: " + 0.0 + ChatColor.GOLD + " Coins" );
        lore.add("");
        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Click to view product!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK , 1 , false);
        meta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.removeItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        stack.setItemMeta(meta);
      return stack;
    }
    public static void init(){
        ArrayList<SMaterial> items = new ArrayList<>();
        items.add(SMaterial.WHEAT);
        BazaarCategory category = new BazaarCategory(new ItemStack(Material.WHEAT) , "Wheat & Seeds" ,items);
        categoryManger manger = new categoryManger();
        manger.addToCategories(category);
    }
}

