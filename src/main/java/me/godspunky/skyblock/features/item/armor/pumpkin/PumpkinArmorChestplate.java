package me.godspunky.skyblock.features.item.armor.pumpkin;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class PumpkinArmorChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseHealth() {
        return 14;
    }

    @Override
    public double getBaseDefense() {
        return 14;
    }

    @Override
    public String getDisplayName() {
        return "Pumpkin Chestplate";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public int getColor() {
        return 0xEDAA36;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public void load(){
        SUtil.ChestplateRecipe(SMaterial.PUMPKIN_ARMOR_CHESTPLATE, SMaterial.PUMPKIN);
    }
}