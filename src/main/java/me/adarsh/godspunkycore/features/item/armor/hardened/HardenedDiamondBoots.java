package me.adarsh.godspunkycore.features.item.armor.hardened;

import me.adarsh.godspunkycore.features.item.*;


public class HardenedDiamondBoots implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Hardened Diamond Boots";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
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
        return 55;
    }
}