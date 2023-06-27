package me.adarsh.godspunkycore.features.item.storage;

import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SkullStatistics;

public class MediumBackpack extends Storage implements SkullStatistics {
    @Override
    public int getSlots() {
        return 18;
    }

    @Override
    public String getDisplayName() {
        return "Medium Backpack";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public String getURL() {
        return "62f3b3a05481cde77240005c0ddcee1c069e5504a62ce0977879f55a39396146";
    }
}