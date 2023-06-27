package me.adarsh.godspunkycore.features.item.oddities;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;

public class Bedrock implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Bedrock";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.BLOCK;
    }

    @Override
    public String getLore() {
        return "How do you have this??";
    }
}