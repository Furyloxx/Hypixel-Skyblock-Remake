package me.godspunky.skyblock.features.item.armor.vanilla.diamond;

import me.godspunky.skyblock.features.item.*;

public class DiamondChestplate implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Diamond Chestplate";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public double getBaseDefense() {
        return 40;
    }
}
