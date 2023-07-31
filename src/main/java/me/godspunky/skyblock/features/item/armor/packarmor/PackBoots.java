package me.godspunky.skyblock.features.item.armor.packarmor;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class PackBoots implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Boots of the Pack";
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
        return 75;
    }

    @Override
    public double getBaseHealth() {
        return 75;
    }
}
