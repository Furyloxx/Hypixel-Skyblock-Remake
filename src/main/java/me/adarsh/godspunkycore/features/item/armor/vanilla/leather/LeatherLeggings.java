package me.adarsh.godspunkycore.features.item.armor.vanilla.leather;

import me.adarsh.godspunkycore.features.item.*;

public class LeatherLeggings implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Leather Chestplate";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
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
        return 10;
    }
}
