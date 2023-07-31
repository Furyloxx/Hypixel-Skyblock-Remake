package me.godspunky.skyblock.features.item.armor.spooky;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class SpookyChestplate implements LeatherArmorStatistics, MaterialFunction {

    @Override
    public double getBaseDefense() {
        return 50;
    }

    @Override
    public String getDisplayName() {
        return "Spooky Chestplate";
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
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public int getColor() {
        return 0x606060;
    }
}