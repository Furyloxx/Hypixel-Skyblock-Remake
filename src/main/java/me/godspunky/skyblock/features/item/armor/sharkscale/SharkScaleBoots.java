package me.godspunky.skyblock.features.item.armor.sharkscale;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class SharkScaleBoots implements LeatherArmorStatistics, MaterialFunction {

    @Override
    public double getBaseDefense() {
        return 100;
    }

    @Override
    public double getBaseHealth(){return 100;}

    @Override
    public String getDisplayName() {
        return "Shark Scale Boots";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
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
        return 0x002CA6;
    }
}
