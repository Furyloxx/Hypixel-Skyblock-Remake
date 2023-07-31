package me.godspunky.skyblock.features.item.armor.cactus;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class CactusArmorLeggings implements LeatherArmorStatistics, MaterialFunction {

    @Override
    public double getBaseDefense() {
        return 20;
    }

    @Override
    public double getBaseHealth(){return 10;}

    @Override
    public String getDisplayName() {
        return "Cactus Leggings";
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
        return SpecificItemType.LEGGINGS;
    }
}
