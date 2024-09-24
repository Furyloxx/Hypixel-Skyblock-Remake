package me.godspunky.skyblock.features.item.tarantula;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SkullStatistics;

public class SpiderCatalyst implements SkullStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Spider Catalyst";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.SLAYER_ITEM;
    }

    @Override
    public String getURL() {
        return "983b30e9d135b05190eea2c3ac61e2ab55a2d81e1a58dbb26983a14082664";
    }
}