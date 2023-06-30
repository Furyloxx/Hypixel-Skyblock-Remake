package me.adarsh.godspunkycore.features.item.armor.cactus;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class CactusArmorChestplate implements LeatherArmorStatistics, MaterialFunction {

    @Override
    public double getBaseDefense() {
        return 25;
    }

    @Override
    public double getBaseHealth(){return 15;}

    @Override
    public String getDisplayName() {
        return "Cactus Chestplate";
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
        return 0x00FF00;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.CHESTPLATE;
    }
}