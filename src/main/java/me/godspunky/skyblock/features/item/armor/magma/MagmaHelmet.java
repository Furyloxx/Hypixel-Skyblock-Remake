package me.godspunky.skyblock.features.item.armor.magma;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class MagmaHelmet implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Armor of Magma Helmet";
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
        return SpecificItemType.HELMET;
    }

    @Override
    public double getBaseHealth(){return 15;}

    @Override
    public double getBaseDefense() {
        return 50;
    }

    @Override
    public int getColor() {
        return 0xFF9300;
    }

    @Override
    public void load() {
        SUtil.HelmetRecipe(SMaterial.MAGMA_HELMET,SMaterial.ENCHANTED_MAGMA_CREAM,12);
    }
}
