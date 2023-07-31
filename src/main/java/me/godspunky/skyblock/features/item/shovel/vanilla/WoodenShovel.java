package me.godspunky.skyblock.features.item.shovel.vanilla;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;


public class WoodenShovel implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Wooden Shovel";
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
        return SpecificItemType.SHOVEL;
    }
}