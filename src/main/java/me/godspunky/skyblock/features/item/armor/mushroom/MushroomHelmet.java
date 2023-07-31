package me.godspunky.skyblock.features.item.armor.mushroom;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class MushroomHelmet implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseHealth() {
        return 20;
    }

    @Override
    public String getDisplayName() {
        return "Mushroom Helmet";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.HELMET;
    }

    @Override
    public int getColor() {
        return 0xFF0000;
    }
}
