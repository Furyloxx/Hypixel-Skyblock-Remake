package me.godspunky.skyblock.features.item.armor.hardened;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.util.SUtil;


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

    @Override
    public void load() {
        SUtil.BootsRecipe(SMaterial.HARDENED_DIAMOND_BOOTS,SMaterial.ENCHANTED_DIAMOND);
    }
}