package me.godspunky.skyblock.features.item.enchanted;

import me.godspunky.skyblock.features.item.MaterialQuantifiable;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.features.item.ShapelessRecipe;


public interface EnchantedMaterialStatistics extends MaterialStatistics {
    SMaterial getCraftingMaterial();

    MaterialQuantifiable getResult();

    default SMaterial getBlockCraftingMaterial() {
        return null;
    }

    default MaterialQuantifiable getBlockResult() {
        return null;
    }

    default int getCraftingRequiredAmount() {
        return 32;
    }

    @Override
    default void load() {
        if (getBlockCraftingMaterial() != null && getBlockResult() != null)
            createRecipe(new MaterialQuantifiable(getBlockCraftingMaterial(), getCraftingRequiredAmount()), getBlockResult());
        createRecipe(new MaterialQuantifiable(getCraftingMaterial(), getCraftingRequiredAmount()), getResult());
    }

    static void createRecipe(MaterialQuantifiable material, MaterialQuantifiable result) {
        new ShapelessRecipe(result.getMaterial(), result.getAmount())
                .add(material)
                .add(material)
                .add(material)
                .add(material)
                .add(material);
    }
}