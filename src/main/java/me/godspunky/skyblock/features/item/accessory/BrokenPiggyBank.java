package me.godspunky.skyblock.features.item.accessory;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;

public class BrokenPiggyBank implements AccessoryStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "b590207aeea2d8fc80194f2a109f5b1999c91ebd377dff01b9e7ebe091a3a419";
    }

    @Override
    public String getDisplayName() {
        return "Broken Piggy Bank";
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
    public String getLore() {
        return "It broke!";
    }
}