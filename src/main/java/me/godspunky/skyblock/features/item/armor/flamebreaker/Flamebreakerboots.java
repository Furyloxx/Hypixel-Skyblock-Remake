package me.godspunky.skyblock.features.item.armor.flamebreaker;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.util.SUtil;

public class Flamebreakerboots implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Flamebreaker Boots";
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
        return 35;
    }

    @Override
    public double getBaseHealth() {
        return 35;
    }

    @Override
    public void load() {
        ShapedRecipe recipe = new ShapedRecipe(SMaterial.FLAMEBREAKER_BOOTS);
        recipe.shape("a a", "a a", "aaa");
        recipe.set('a', SMaterial.COAL, 1);
    }
}
