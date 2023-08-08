package me.godspunky.skyblock.features.item.enchanted.combat;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.enchanted.EnchantedMaterialStatistics;

public class EnchantedBlazeRod implements EnchantedMaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Enchanted Blaze Rod";
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
        return SMaterial.BLAZE_ROD;
    }

    @Override
    public MaterialQuantifiable getResult() {
        return new MaterialQuantifiable(SMaterial.ENCHANTED_BLAZE_ROD);
    }
}
