package me.adarsh.godspunkycore.item.armor.pumpkin;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SpecificItemType;
import me.adarsh.godspunkycore.item.armor.LeatherArmorStatistics;

public class PumpkinArmorLeggings implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseHealth() {
        return 10;
    }

    @Override
    public double getBaseDefense() {
        return 10;
    }

    @Override
    public String getDisplayName() {
        return "Pumpkin Leggings";
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
        return 0xEDAA36;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.LEGGINGS;
    }
}