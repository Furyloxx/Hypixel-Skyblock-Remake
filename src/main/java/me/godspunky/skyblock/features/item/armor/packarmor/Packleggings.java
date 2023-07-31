package me.godspunky.skyblock.features.item.armor.packarmor;

import me.godspunky.skyblock.features.item.*;

public class Packleggings implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Leggings of the Pack";
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
        return 75;
    }

    @Override
    public double getBaseHealth() {
        return 80;
    }
}
