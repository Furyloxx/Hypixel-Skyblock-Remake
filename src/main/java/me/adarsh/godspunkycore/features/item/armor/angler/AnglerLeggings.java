package me.adarsh.godspunkycore.features.item.armor.angler;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class AnglerLeggings implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 30;
    }

    @Override
    public String getDisplayName() {
        return "Angler Leggings";
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
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public int getColor() {
        return 0x0B004F;
    }
}
