package me.adarsh.godspunkycore.item.pickaxe.vanilla;

import me.adarsh.godspunkycore.item.*;

public class GoldenPickaxe implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Golden Pickaxe";
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
        return SpecificItemType.PICKAXE;
    }
}