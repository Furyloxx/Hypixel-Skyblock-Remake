package me.godspunky.skyblock.features.item.armor.cactus;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class CactusArmorChestplate implements LeatherArmorStatistics, MaterialFunction {

    @Override
    public double getBaseDefense() {
        return 25;
    }

    @Override
    public double getBaseHealth(){return 15;}

    @Override
    public String getDisplayName() {
        return "Cactus Chestplate";
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
        return 0x00FF00;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public void load(){
        SUtil.ChestplateRecipe(SMaterial.CACTUS_CHESTPLATE, SMaterial.CACTUS);
    }
}