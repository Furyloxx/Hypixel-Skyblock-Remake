package me.godspunky.skyblock.features.item.armor.magma;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class MagmaChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Armor of Magma Chestplate";
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
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public double getBaseHealth(){return 100;}

    @Override
    public double getBaseDefense() {
        return 30;
    }

    @Override
    public int getColor() {
        return 0xFF9300;
    }

    @Override
    public void load() {
        SUtil.ChestplateRecipe(SMaterial.MAGMA_CHESTPLATE,SMaterial.ENCHANTED_MAGMA_CREAM,12);
    }
}

