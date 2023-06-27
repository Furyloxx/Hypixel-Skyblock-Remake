package me.adarsh.godspunkycore.features.item.armor.pumpkin;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class PumpkinArmorBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseHealth() {
        return 8;
    }

    @Override
    public double getBaseDefense() {
        return 8;
    }

    @Override
    public String getDisplayName() {
        return "Pumpkin Boots";
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
        return SpecificItemType.BOOTS;
    }
}