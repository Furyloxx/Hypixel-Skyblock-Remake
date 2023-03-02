package me.adarsh.godspunkycore.item.mining;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.MaterialStatistics;
import me.adarsh.godspunkycore.item.Rarity;

public class Coal implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Coal";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public long getPrice() {
        return 100L;
    }
}
