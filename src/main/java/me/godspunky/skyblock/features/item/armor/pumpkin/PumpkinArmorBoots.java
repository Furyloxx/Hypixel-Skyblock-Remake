package me.godspunky.skyblock.features.item.armor.pumpkin;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class PumpkinArmorBoots implements LeatherArmorStatistics, MaterialFunction {
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
        return "Pumpkin Boots";
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
        return SpecificItemType.BOOTS;
    }

    @Override
    public void load(){
        SUtil.BootsRecipe(SMaterial.PUMPKIN_ARMOR_BOOTS, SMaterial.PUMPKIN);
    }
}