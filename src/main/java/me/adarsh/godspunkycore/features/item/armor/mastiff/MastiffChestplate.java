package me.adarsh.godspunkycore.features.item.armor.mastiff;

import me.adarsh.godspunkycore.features.item.*;

public class MastiffChestplate implements MaterialFunction, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Mastiff Chestplate";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public double getBaseDefense() {
        return -1000000;
    }

    @Override
    public double getBaseHealth() {
        return 500;
    }
}
