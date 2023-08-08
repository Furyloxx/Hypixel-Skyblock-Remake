package me.godspunky.skyblock.features.item.enchanted.combat;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.enchanted.EnchantedMaterialStatistics;

public class EnchantedBone implements EnchantedMaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Enchanted Bone";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
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
        return SMaterial.BONE;
    }

    @Override
    public MaterialQuantifiable getResult() {
        return new MaterialQuantifiable(SMaterial.ENCHANTED_BONE);
    }
}