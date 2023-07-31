package me.godspunky.skyblock.features.item.dragon.strong;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class StrongDragonBoots implements MaterialFunction, LeatherArmorStatistics {
    @Override
    public double getBaseStrength() {
        return 25;
    }

    @Override
    public double getBaseHealth() {
        return 60;
    }

    @Override
    public double getBaseDefense() {
        return 90;
    }

    @Override
    public int getColor() {
        return 0xF0D124;
    }

    @Override
    public String getDisplayName() {
        return "Strong Dragon Boots";
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
    public String getLore() {
        return null;
    }
}