package me.godspunky.skyblock.features.item.axe.vanilla.axe;

import me.godspunky.skyblock.features.item.*;

public class RookieAxe implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Rookie Axe";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public int getBaseDamage() {
        return 20;
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
