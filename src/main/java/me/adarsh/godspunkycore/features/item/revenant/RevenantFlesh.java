package me.adarsh.godspunkycore.features.item.revenant;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;

public class RevenantFlesh implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Revenant Flesh";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
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