package me.godspunky.skyblock.features.item.armor.pumpkin;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class PumpkinArmorHelmet implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseHealth() {
        return 8;
    }

    @Override
    public double getBaseDefense() {
        return 8;
    }

    @Override
    public String getDisplayName() {
        return "Pumpkin Helmet";
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
        return SpecificItemType.HELMET;
    }

    @Override
    public void load(){
        SUtil.HelmetRecipe(SMaterial.PUMPKIN_ARMOR_HELMET, SMaterial.PUMPKIN);
    }
}
