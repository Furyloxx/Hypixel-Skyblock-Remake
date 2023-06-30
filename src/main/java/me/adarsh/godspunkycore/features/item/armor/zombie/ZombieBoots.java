package me.adarsh.godspunkycore.features.item.armor.zombie;

import me.adarsh.godspunkycore.features.item.*;

public class ZombieBoots implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Zombie Boots";
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
    public double getBaseHealth() {
        return 120;
    }

    @Override
    public double getBaseDefense() {
        return 25;
    }
}
