package me.godspunky.skyblock.features.item.armor.golem;

import me.godspunky.skyblock.features.item.*;

public class GolemArmorHelmet implements ToolStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 45;
    }

    @Override
    public double getBaseHealth() {
        return 45;
    }

    @Override
    public String getDisplayName() {
        return "Golem Armor Helmet";
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
        return SpecificItemType.HELMET;
    }
}
