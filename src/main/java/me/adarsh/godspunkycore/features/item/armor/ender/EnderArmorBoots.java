package me.adarsh.godspunkycore.features.item.armor.ender;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class EnderArmorBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Ender Armor Boots";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public double getBaseHealth() {
        return 15;
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
    public double getBaseDefense() {
        return 25;
    }

    @Override
    public int getColor() {
        return 0x0000FF;
    }
}

