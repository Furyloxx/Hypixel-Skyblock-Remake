package me.adarsh.godspunkycore.features.item.armor.zombie;

import me.adarsh.godspunkycore.features.item.*;

public class ZombieLeggings implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Zombie Leggings";
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
    public double getBaseHealth() {
        return 160;
    }

    @Override
    public double getBaseDefense() {
        return 30;
    }
}
