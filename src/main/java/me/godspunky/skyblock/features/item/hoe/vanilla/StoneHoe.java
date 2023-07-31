package me.godspunky.skyblock.features.item.hoe.vanilla;

import me.godspunky.skyblock.features.item.*;

public class StoneHoe implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Stone Hoe";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.TOOL;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.HOE;
    }
}