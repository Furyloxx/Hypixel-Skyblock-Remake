package me.godspunky.skyblock.features.item.armor.flamebreaker;

import me.godspunky.skyblock.features.item.*;

public class FlamebreakerHelmet implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Flamebreaker helmet";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
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
        return 40;
    }

    @Override
    public double getBaseHealth() {
        return 40;
    }

    @Override
    public void load() {
        ShapedRecipe recipe = new ShapedRecipe(SMaterial.FLAMEBREAKER_HELMET);
        recipe.shape("aaa", "a a", "a a");
        recipe.set('a', SMaterial.COAL, 1);
    }
}
