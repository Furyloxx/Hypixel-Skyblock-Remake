package me.adarsh.godspunkycore.features.item.armor.golem;

import me.adarsh.godspunkycore.features.item.*;

public class GolemArmorLeggings implements ToolStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 75;
    }

    @Override
    public double getBaseHealth() {
        return 55;
    }

    @Override
    public String getDisplayName() {
        return "Golem Armor Leggings";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.LEGGINGS;
    }
}

