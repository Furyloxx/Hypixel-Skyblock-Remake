package me.godspunky.skyblock.features.item.enchanted.farming;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.enchanted.EnchantedMaterialStatistics;

public class EnchantedMelonBlock implements EnchantedMaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Enchanted Melon Block";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
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
        return SMaterial.MELON_BLOCK;
    }

    @Override
    public MaterialQuantifiable getResult() {
        return new MaterialQuantifiable(SMaterial.ENCHANTED_MELON_BLOCK);
    }
}