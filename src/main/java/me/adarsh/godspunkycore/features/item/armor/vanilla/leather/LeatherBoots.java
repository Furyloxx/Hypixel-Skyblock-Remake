package me.adarsh.godspunkycore.features.item.armor.vanilla.leather;

import me.adarsh.godspunkycore.features.item.*;

public class LeatherBoots implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Leather Boots";
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
        return SpecificItemType.BOOTS;
    }

    @Override
    public double getBaseDefense() {
        return 5;
    }
}
