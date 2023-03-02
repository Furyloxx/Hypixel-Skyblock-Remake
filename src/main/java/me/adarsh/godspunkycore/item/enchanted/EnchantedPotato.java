package me.adarsh.godspunkycore.item.enchanted;

import me.adarsh.godspunkycore.item.*;

public class EnchantedPotato implements EnchantedMaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Enchanted Potato";
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
        return SMaterial.POTATO_ITEM;
    }

    @Override
    public MaterialQuantifiable getResult() {
        return new MaterialQuantifiable(SMaterial.ENCHANTED_POTATO);
    }
}