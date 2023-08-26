package me.godspunky.skyblock.features.item.armor.hardened;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.util.SUtil;

public class HardenedDiamondLeggings implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Hardened Diamond Leggings";
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
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public double getBaseDefense() {
        return 95;
    }

    @Override
    public void load() {
        SUtil.LeggingsRecipe(SMaterial.HARDENED_DIAMOND_LEGGINGS,SMaterial.ENCHANTED_DIAMOND);
    }

}