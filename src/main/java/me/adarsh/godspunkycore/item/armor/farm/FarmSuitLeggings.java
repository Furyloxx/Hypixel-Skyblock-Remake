package me.adarsh.godspunkycore.item.armor.farm;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SpecificItemType;
import me.adarsh.godspunkycore.item.armor.LeatherArmorStatistics;

public class FarmSuitLeggings implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 30;
    }

    @Override
    public String getDisplayName() {
        return "Farm Suit Leggings";
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
    public int getColor() {
        return 0xFFFF00;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.LEGGINGS;
    }
}