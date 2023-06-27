package me.adarsh.godspunkycore.features.item.oddities;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;

public class SummoningFrame implements MaterialFunction, MaterialStatistics {
    @Override
    public String getDisplayName() {
        return "Summoning Frame";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EXCLUSIVE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.BLOCK;
    }
}