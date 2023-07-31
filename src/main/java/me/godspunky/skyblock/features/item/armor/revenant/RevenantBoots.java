package me.godspunky.skyblock.features.item.armor.revenant;

import me.godspunky.skyblock.features.item.*;

public class RevenantBoots implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Revenant Boots";
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
        return 30;
    }

    @Override
    public double getBaseHealth() {
        return 100;
    }
}
