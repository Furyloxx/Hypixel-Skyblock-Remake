package me.godspunky.skyblock.features.item.pickaxe.vanilla.pickaxe;

import me.godspunky.skyblock.features.item.*;

public class RookiePickaxe implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Rookie Pickaxe";
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
