package me.adarsh.godspunkycore.features.item.armor.vanilla.diamond;

import me.adarsh.godspunkycore.features.item.*;

public class DiamondBoots implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Diamond Boots";
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
        return SpecificItemType.BOOTS;
    }

    @Override
    public double getBaseDefense() {
        return 15;
    }
}
