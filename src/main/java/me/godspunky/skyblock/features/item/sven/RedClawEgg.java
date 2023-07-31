package me.godspunky.skyblock.features.item.sven;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.Rarity;

public class RedClawEgg implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Red Claw Egg";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }
}