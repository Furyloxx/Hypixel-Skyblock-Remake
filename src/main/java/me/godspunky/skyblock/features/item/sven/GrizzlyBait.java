package me.godspunky.skyblock.features.item.sven;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.Rarity;

public class GrizzlyBait implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Grizzly Bait";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }
}