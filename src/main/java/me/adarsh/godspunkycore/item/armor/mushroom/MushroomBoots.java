package me.adarsh.godspunkycore.item.armor.mushroom;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SpecificItemType;
import me.adarsh.godspunkycore.item.armor.LeatherArmorStatistics;

public class MushroomBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseHealth() {
        return 15;
    }

    @Override
    public String getDisplayName() {
        return "Mushroom Boots";
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
        return SpecificItemType.BOOTS;
    }

    @Override
    public int getColor() {
        return 0xFF0000;
    }
}
