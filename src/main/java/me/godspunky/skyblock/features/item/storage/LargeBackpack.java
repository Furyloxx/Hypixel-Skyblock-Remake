package me.godspunky.skyblock.features.item.storage;

import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SkullStatistics;

public class LargeBackpack extends Storage implements SkullStatistics {
    @Override
    public int getSlots() {
        return 27;
    }

    @Override
    public String getDisplayName() {
        return "Large Backpack";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public String getURL() {
        return "62f3b3a05481cde77240005c0ddcee1c069e5504a62ce0977879f55a39396146";
    }
}