package me.adarsh.godspunkycore.features.item.armor.magma;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class MagmaHelmet implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Armor of Magma Helmet";
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
        return SpecificItemType.HELMET;
    }

    @Override
    public double getBaseHealth(){return 15;}

    @Override
    public double getBaseDefense() {
        return 50;
    }

    @Override
    public int getColor() {
        return 0xFF9300;
    }
}
