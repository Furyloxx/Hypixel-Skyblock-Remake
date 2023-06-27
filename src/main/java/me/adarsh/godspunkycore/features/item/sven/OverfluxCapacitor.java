package me.adarsh.godspunkycore.features.item.sven;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;

public class OverfluxCapacitor implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Overflux Capacitor";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public boolean isEnchanted() {
        return true;
    }
}