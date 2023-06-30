package me.adarsh.godspunkycore.features.item.accessory;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;

public class SpeedRing implements AccessoryStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "c2da40a91f8fa7e1cbdd934da92a7668dc95d75b57c9c80a381c5e178cee6ba7";
    }

    @Override
    public String getDisplayName() {
        return "Speed Ring";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ACCESSORY;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.ACCESSORY;
    }

    @Override
    public double getBaseSpeed() {
        return 0.3;
    }
}


