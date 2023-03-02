package me.adarsh.godspunkycore.item.pickaxe.vanilla;

import me.adarsh.godspunkycore.item.*;

public class IronPickaxe implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Iron Pickaxe";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public int getBaseDamage() {
        return 25;
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