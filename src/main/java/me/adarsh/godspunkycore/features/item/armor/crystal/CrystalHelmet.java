package me.adarsh.godspunkycore.features.item.armor.crystal;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class CrystalHelmet implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Crystal Helmet";
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
    public double getBaseIntelligence(){return 0.65;}

    @Override
    public double getBaseDefense() {
        return 20;
    }

    @Override
    public int getColor() {
        return 0xFFFFFF;
    }
}

