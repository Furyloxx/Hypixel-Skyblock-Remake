package me.godspunky.skyblock.features.item.dragon.unstable;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class UnstableDragonLeggings implements MaterialFunction, LeatherArmorStatistics {
    @Override
    public double getBaseCritChance() {
        return 0.05;
    }

    @Override
    public double getBaseCritDamage() {
        return 0.15;
    }

    @Override
    public double getBaseHealth() {
        return 100;
    }

    @Override
    public double getBaseDefense() {
        return 140;
    }

    @Override
    public int getColor() {
        return 0xB212E3;
    }

    @Override
    public String getDisplayName() {
        return "Unstable Dragon Leggings";
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
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public String getLore() {
        return null;
    }
}