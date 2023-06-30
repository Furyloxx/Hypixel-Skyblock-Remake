package me.adarsh.godspunkycore.features.bazaar;

import java.util.ArrayList;

public class CategoryManger {

    static ArrayList<BazaarCategory> categories = new ArrayList<>();


    public static void addToCategories(BazaarCategory category){
        categories.add(category);
    }
    public static ArrayList<BazaarCategory> getCategories(){
        return categories;
    }



}
