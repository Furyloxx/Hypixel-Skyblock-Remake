package me.godspunky.skyblock.features.item.armor.growth;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class GrowthChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 50;
    }

    @Override
    public double getBaseHealth(){return 100;}

    @Override
    public String getDisplayName() {
        return "Chestplate of Growth";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public int getColor() {
        return 0x00BE00;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.CHESTPLATE;
    }
}

