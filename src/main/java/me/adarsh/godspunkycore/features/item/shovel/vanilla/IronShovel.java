package me.adarsh.godspunkycore.features.item.shovel.vanilla;

import me.adarsh.godspunkycore.features.item.*;

public class IronShovel implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Iron Shovel";
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
        return SpecificItemType.SHOVEL;
    }
}