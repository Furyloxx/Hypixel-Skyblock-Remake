package me.adarsh.godspunkycore.features.item.armor.rosetta;

import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class RosettaHelmet implements ToolStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 20;
    }

    @Override
    public String getDisplayName() {
        return "Rosetta's Helmet";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.HELMET;
    }
}
