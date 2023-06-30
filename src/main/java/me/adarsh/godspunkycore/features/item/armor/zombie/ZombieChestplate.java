package me.adarsh.godspunkycore.features.item.armor.zombie;

import me.adarsh.godspunkycore.features.item.*;

public class ZombieChestplate implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Zombie Chestplate";
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
    public double getBaseHealth() {
        return 200;
    }

    @Override
    public double getBaseDefense() {
        return 30;
    }
}
