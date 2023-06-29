package me.adarsh.godspunkycore.features.item.armor.magma;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class MagmaBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Armor of Magma Boots";
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
        return SpecificItemType.BOOTS;
    }

    @Override
    public double getBaseHealth(){return 45;}

    @Override
    public double getBaseDefense() {
        return 15;
    }

    @Override
    public int getColor() {
        return 0xFF9300;
    }
}

