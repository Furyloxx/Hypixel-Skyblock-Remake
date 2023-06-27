package me.adarsh.godspunkycore.features.item.dragon.young;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class YoungDragonLeggings implements MaterialFunction, LeatherArmorStatistics {
    @Override
    public double getBaseSpeed() {
        return 0.2;
    }

    @Override
    public double getBaseHealth() {
        return 110;
    }

    @Override
    public double getBaseDefense() {
        return 140;
    }

    @Override
    public int getColor() {
        return 0xDDE4F0;
    }

    @Override
    public String getDisplayName() {
        return "Young Dragon Leggings";
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