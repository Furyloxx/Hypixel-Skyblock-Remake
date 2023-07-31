package me.godspunky.skyblock.features.item.armor.vanilla.golden;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class GoldenLeggings implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Golden Chestplate";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public double getBaseDefense() {
        return 15;
    }
}
