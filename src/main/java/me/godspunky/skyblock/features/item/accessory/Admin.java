package me.godspunky.skyblock.features.item.accessory;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;

public class Admin implements AccessoryStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "a88f8b5510b73a5045f59217e1cac48946a7040c419242db9c04e4c5d0bf7a3a";
    }

    @Override
    public String getDisplayName() {
        return "Titanium Tesseract";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ADMIN;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ACCESSORY;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.ACCESSORY;
    }

    @Override
    public double getBaseHealth() {
        return 69690;
    }

    @Override
    public double getBaseDefense() {
        return 696900;
    }

    @Override
    public double getBaseSpeed() {
        return 6.9;
    }
}
