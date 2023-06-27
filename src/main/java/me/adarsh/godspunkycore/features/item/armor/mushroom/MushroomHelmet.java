package me.adarsh.godspunkycore.features.item.armor.mushroom;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

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
