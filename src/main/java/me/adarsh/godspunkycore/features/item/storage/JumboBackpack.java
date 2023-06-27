package me.adarsh.godspunkycore.features.item.storage;

import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SkullStatistics;

public class JumboBackpack extends Storage implements SkullStatistics {
    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public String getDisplayName() {
        return "Jumbo Backpack";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public String getURL() {
        return "1f8405116c1daa7ce2f012591458d50246d0a467bcb95a5a2c033aefd6008b63";
    }
}