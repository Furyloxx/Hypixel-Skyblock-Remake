package me.godspunky.skyblock.features.item.armor.vanilla.iron;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class IronBoots implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Iron Boots";
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
        return SpecificItemType.BOOTS;
    }

    @Override
    public double getBaseDefense() {
        return 10;
    }
}
