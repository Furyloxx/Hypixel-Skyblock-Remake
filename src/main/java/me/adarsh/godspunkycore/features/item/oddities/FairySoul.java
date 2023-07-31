package me.adarsh.godspunkycore.features.item.oddities;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SkullStatistics;

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
