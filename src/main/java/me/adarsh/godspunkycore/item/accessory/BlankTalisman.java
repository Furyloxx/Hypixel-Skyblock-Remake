package me.adarsh.godspunkycore.item.accessory;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SpecificItemType;


public class BlankTalisman implements AccessoryStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Blank Talisman";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EXCLUSIVE;
    }

    @Override
    public String getLore() {
        return "Apply reforges to this talisman to get effects.";
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
    public String getURL() {
        return "1ad6c81f899a785ecf26be1dc48eae2bcfe777a862390f5785e95bd83bd14d";
    }
}
