package me.godspunky.skyblock.features.item.armor.revenant;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class RevenantLeggings implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Revenant Leggings";
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
    public double getBaseDefense() {
        return 50;
    }

    @Override
    public double getBaseHealth() {
        return 130;
    }
}

