package me.adarsh.godspunkycore.features.item.armor.ender;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class EnderArmorLeggings implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Ender Armor Leggings";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public double getBaseHealth() {
        return 25;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public double getBaseDefense() {
        return 50;
    }

    @Override
    public int getColor() {
        return 0x0000FF;
    }
}

