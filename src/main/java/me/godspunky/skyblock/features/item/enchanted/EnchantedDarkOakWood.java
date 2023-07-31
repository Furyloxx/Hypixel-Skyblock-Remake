package me.godspunky.skyblock.features.item.enchanted;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class EnchantedDarkOakWood implements EnchantedMaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Enchanted Dark Oak Wood";
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
    public MaterialQuantifiable getResult() {
        return new MaterialQuantifiable(SMaterial.ENCHANTED_DARK_OAK_WOOD);
    }

    @Override
    public SMaterial getCraftingMaterial() {
        return SMaterial.DARK_OAK_WOOD;
    }
}