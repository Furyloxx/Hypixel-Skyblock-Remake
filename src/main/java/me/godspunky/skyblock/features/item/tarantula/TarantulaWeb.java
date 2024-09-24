package me.godspunky.skyblock.features.item.tarantula;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.Rarity;

public class TarantulaWeb implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Tarantula Web";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.SLAYER_ITEM;
    }

    @Override
    public boolean isEnchanted() {
        return true;
    }
}