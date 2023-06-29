package me.adarsh.godspunkycore.features.item.armor.magma;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class MagmaChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Armor of Magma Chestplate";
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
    public double getBaseHealth(){return 100;}

    @Override
    public double getBaseDefense() {
        return 30;
    }

    @Override
    public int getColor() {
        return 0xFF9300;
    }
}

