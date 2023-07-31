package me.godspunky.skyblock.features.item.oddities;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.Rarity;

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