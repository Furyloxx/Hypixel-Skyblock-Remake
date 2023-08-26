package me.godspunky.skyblock.features.item.armor.farm;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class FarmSuitBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 15;
    }

    @Override
    public String getDisplayName() {
        return "Farm Suit Boots";
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
        return SpecificItemType.BOOTS;
    }

    @Override
    public void load(){
        SUtil.BootsRecipe(SMaterial.FARM_SUIT_BOOTS, SMaterial.HAY_BLOCK);
    }
}