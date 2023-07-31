package me.godspunky.skyblock.features.item.armor.golem;

import me.godspunky.skyblock.features.item.*;

public class GolemArmorChestplate implements ToolStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 90;
    }

    @Override
    public double getBaseHealth() {
        return 65;
    }

    @Override
    public String getDisplayName() {
        return "Golem Armor Chestplate";
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
        return SpecificItemType.CHESTPLATE;
    }
}
