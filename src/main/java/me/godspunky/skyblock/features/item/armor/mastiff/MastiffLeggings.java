package me.godspunky.skyblock.features.item.armor.mastiff;

import me.godspunky.skyblock.features.item.*;

public class MastiffLeggings implements MaterialFunction, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Mastiff Leggings";
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
        return SpecificItemType.LEGGINGS;
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
