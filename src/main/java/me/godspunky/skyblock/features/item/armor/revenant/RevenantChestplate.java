package me.godspunky.skyblock.features.item.armor.revenant;

import me.godspunky.skyblock.features.item.*;

public class RevenantChestplate implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Revenant Chestplate";
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
    public double getBaseDefense() {
        return 70;
    }

    @Override
    public double getBaseHealth() {
        return 180;
    }
}

