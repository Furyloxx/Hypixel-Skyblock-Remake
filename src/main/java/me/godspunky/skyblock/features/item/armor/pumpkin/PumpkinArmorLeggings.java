package me.godspunky.skyblock.features.item.armor.pumpkin;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class PumpkinArmorLeggings implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseHealth() {
        return 10;
    }

    @Override
    public double getBaseDefense() {
        return 10;
    }

    @Override
    public String getDisplayName() {
        return "Pumpkin Leggings";
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
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public void load(){
        SUtil.LeggingsRecipe(SMaterial.PUMPKIN_ARMOR_LEGGINGS, SMaterial.PUMPKIN);
    }
}