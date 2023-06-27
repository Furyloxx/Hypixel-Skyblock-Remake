package me.adarsh.godspunkycore.features.item.axe.vanilla;

import me.adarsh.godspunkycore.features.item.*;

public class StoneAxe implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Stone Axe";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public int getBaseDamage() {
        return 15;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.TOOL;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.AXE;
    }
}