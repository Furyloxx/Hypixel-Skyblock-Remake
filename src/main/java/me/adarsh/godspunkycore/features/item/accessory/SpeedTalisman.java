package me.adarsh.godspunkycore.features.item.accessory;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;

public class SpeedTalisman implements AccessoryStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "f06706eecb2d558ace27abda0b0b7b801d36d17dd7a890a9520dbe522374f8a6";
    }

    @Override
    public String getDisplayName() {
        return "Speed Talisman";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
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
        return 0.1;
    }
}

