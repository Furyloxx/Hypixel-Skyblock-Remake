package me.godspunky.skyblock.features.item.oddities;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SkullStatistics;

public class FairySoul implements SkullStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Fairy Soul";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.VERY_SPECIAL;
    }

    @Override
    public String getLore() {
        return "Place it!";
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public boolean isStackable() {
        return false;
    }

    @Override
    public String getURL() {
        return "b96923ad247310007f6ae5d326d847ad53864cf16c3565a181dc8e6b20be2387";
    }
}
