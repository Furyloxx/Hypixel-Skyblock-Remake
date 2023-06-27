package me.adarsh.godspunkycore.features.item.enchanted;

import me.adarsh.godspunkycore.features.item.*;

public class EnchantedCoal implements EnchantedMaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Enchanted Coal";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public boolean isEnchanted() {
        return true;
    }

    @Override
    public SMaterial getCraftingMaterial() {
        return SMaterial.COAL;
    }

    @Override
    public MaterialQuantifiable getResult() {
        return new MaterialQuantifiable(SMaterial.ENCHANTED_COAL);
    }

    @Override
    public SMaterial getBlockCraftingMaterial() {
        return SMaterial.COAL_BLOCK;
    }
}