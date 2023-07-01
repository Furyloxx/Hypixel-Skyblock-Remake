package me.adarsh.godspunkycore.features.bazaar;

import me.adarsh.godspunkycore.features.item.SMaterial;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CategoryManger {

    static ArrayList<BazaarCategory> farmingCategories = new ArrayList<>();
    static ArrayList<BazaarCategory> MiningCategories = new ArrayList<>();

    static ArrayList<BazaarCategory> combatCategories = new ArrayList<>();


    public static void initItems(){
        ArrayList<SMaterial> wheatItems = new ArrayList<>();
        // like this we can add items to category
        wheatItems.add(SMaterial.WHEAT);
        wheatItems.add(SMaterial.SEEDS);
        // this is method to way to create Category
        BazaarCategory wheatCategory = new BazaarCategory(new ItemStack(Material.WHEAT) , "Wheat & Seeds" ,wheatItems);
        ArrayList<SMaterial> carrotItems = new ArrayList<>();
        // like this we can add items to category
        carrotItems.add(SMaterial.CARROT);
        carrotItems.add(SMaterial.GOLDEN_CARROT);
        // this is method to way to create Category
        BazaarCategory carrotCategory = new BazaarCategory(new ItemStack(Material.DIAMOND) , "carrot" ,carrotItems);
        // here we have to register Category
        carrotCategory.setIcon(new ItemStack(Material.DIAMOND));
        farmingCategories.add(carrotCategory);
        farmingCategories.add(wheatCategory);
        ArrayList<SMaterial> items = new ArrayList<>();
        // like this we can add items to category
        items.add(SMaterial.COBBLESTONE);
        items.add(SMaterial.STONE);
        // this is method to way to create Category
        BazaarCategory category = new BazaarCategory(new ItemStack(Material.COBBLESTONE) , "Stones" ,items);
        MiningCategories.add(category);


    }



    public static ArrayList<BazaarCategory> getFarmingCategories(){
        return farmingCategories;
    }
    public static ArrayList<BazaarCategory> getMiningCategories(){
        return MiningCategories;
    }
    public static ArrayList<BazaarCategory> getCombatCategories(){
        return combatCategories;
    }


}
