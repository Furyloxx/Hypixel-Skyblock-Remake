package me.adarsh.godspunkycore.features.item.armor.rosetta;

import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class RosettaLeggings implements ToolStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 30;
    }

    @Override
    public String getDisplayName() {
        return "Rosetta's Leggings";
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
        return SpecificItemType.LEGGINGS;
    }
}
