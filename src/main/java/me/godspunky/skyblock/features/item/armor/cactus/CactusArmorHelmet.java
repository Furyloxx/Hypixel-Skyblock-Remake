package me.godspunky.skyblock.features.item.armor.cactus;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class CactusArmorHelmet implements LeatherArmorStatistics, MaterialFunction {

    @Override
    public double getBaseDefense() {
        return 10;
    }

    @Override
    public double getBaseHealth(){return 5;}

    @Override
    public String getDisplayName() {
        return "Cactus Helmet";
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
        return SpecificItemType.HELMET;
    }
}
