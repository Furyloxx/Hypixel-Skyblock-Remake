package me.godspunky.skyblock.features.item.armor.hardened;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.util.SUtil;

public class HardenedDiamondHelmet implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Hardened Diamond Helmet";
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
        return SpecificItemType.HELMET;
    }

    @Override
    public double getBaseDefense() {
        return 60;
    }

    @Override
    public void load() {
        SUtil.HelmetRecipe(SMaterial.HARDENED_DIAMOND_HELMET,SMaterial.ENCHANTED_DIAMOND);
    }
}