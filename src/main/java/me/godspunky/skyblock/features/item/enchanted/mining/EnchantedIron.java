package me.godspunky.skyblock.features.item.enchanted.mining;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.enchanted.EnchantedMaterialStatistics;

public class EnchantedIron implements EnchantedMaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Enchanted Iron";
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
        return SMaterial.IRON_INGOT;
    }

    @Override
    public MaterialQuantifiable getResult() {
        return new MaterialQuantifiable(SMaterial.ENCHANTED_IRON);
    }
}