package me.adarsh.godspunkycore.features.item.enchanted;

import me.adarsh.godspunkycore.features.item.*;

public class EnchantedEnderPearl implements EnchantedMaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Enchanted Ender Pearl";
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
        return SMaterial.ENDER_PEARL;
    }

    @Override
    public int getCraftingRequiredAmount() {
        return 4;
    }

    @Override
    public MaterialQuantifiable getResult() {
        return new MaterialQuantifiable(SMaterial.ENCHANTED_ENDER_PEARL);
    }
}