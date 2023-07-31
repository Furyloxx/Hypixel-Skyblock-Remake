package me.godspunky.skyblock.features.item.dragon.old;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class OldDragonChestplate implements MaterialFunction, LeatherArmorStatistics {
    @Override
    public double getBaseHealth() {
        return 160;
    }

    @Override
    public double getBaseDefense() {
        return 150;
    }

    @Override
    public int getColor() {
        return 0xF0E6AA;
    }

    @Override
    public String getDisplayName() {
        return "Old Dragon Chestplate";
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
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public String getLore() {
        return null;
    }
}