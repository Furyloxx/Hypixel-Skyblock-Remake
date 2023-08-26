package me.godspunky.skyblock.features.item.armor.farm;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class FarmSuitChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 40;
    }

    @Override
    public String getDisplayName() {
        return "Farm Suit Chestplate";
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
        return 0xFFFF00;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public void load(){
        SUtil.ChestplateRecipe(SMaterial.FARM_SUIT_CHESTPLATE, SMaterial.HAY_BLOCK);
    }
}