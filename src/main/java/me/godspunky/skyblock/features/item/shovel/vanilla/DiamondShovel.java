package me.godspunky.skyblock.features.item.shovel.vanilla;

import me.godspunky.skyblock.features.item.*;

public class DiamondShovel implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Diamond Shovel";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public int getBaseDamage() {
        return 30;
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