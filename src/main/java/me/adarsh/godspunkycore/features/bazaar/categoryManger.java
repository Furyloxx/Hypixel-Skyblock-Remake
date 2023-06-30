package me.adarsh.godspunkycore.features.bazaar;

import java.util.ArrayList;

public class categoryManger {

    ArrayList<BazaarCategory> categories = new ArrayList<>();


    public void addToCategories(BazaarCategory category){
        categories.add(category);
    }
    public ArrayList<BazaarCategory> getCategories(){
        return categories;
    }



}
