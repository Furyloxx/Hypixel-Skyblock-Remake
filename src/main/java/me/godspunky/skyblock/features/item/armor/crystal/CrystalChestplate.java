package me.godspunky.skyblock.features.item.armor.crystal;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class CrystalChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Crystal Chestplate";
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
    public double getBaseIntelligence(){return 0.120;}

    @Override
    public double getBaseDefense() {
        return 35;
    }

    @Override
    public int getColor() {
        return 0xFFFFFF;
    }

    @Override
    public void load() {
        SUtil.ChestplateRecipe(SMaterial.CRYSTAL_CHESTPLATE,SMaterial.CRYSTAL_FRAGMENT);
    }
}

