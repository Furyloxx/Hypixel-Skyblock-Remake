package me.adarsh.godspunkycore.features.item.armor.flamebreaker;

import me.adarsh.godspunkycore.features.item.*;

public class Flamebreakerboots implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Flamebreaker Boots";
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
        return SpecificItemType.BOOTS;
    }

    @Override
    public double getBaseDefense() {
        return 35;
    }

    @Override
    public double getBaseHealth() {
        return 35;
    }
}
