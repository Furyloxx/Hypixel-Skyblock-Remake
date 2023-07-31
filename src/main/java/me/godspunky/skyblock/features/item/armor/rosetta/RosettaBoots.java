package me.godspunky.skyblock.features.item.armor.rosetta;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class RosettaBoots implements ToolStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 20;
    }

    @Override
    public String getDisplayName() {
        return "Rosetta's Boots";
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
        return SpecificItemType.BOOTS;
    }
}