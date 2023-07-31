package me.godspunky.skyblock.features.item.armor.miner;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class MinerLeggings implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Miner Leggings";
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
    public SpecificItemType getSpecificType() {
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public double getBaseDefense() {
        return 5;
    }

    @Override
    public int getColor() {
        return 0x0000FF;
    }
}