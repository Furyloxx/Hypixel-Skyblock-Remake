package me.adarsh.godspunkycore.features.item.hoe.vanilla;

import me.adarsh.godspunkycore.features.item.*;

public class GoldenHoe implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Golden Hoe";
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