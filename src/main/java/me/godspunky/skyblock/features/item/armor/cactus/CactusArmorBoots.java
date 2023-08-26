package me.godspunky.skyblock.features.item.armor.cactus;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class CactusArmorBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 10;
    }

    @Override
    public double getBaseHealth(){return 5;}

    @Override
    public String getDisplayName() {
        return "Cactus Boots";
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
        return SpecificItemType.BOOTS;
    }

    @Override
    public void load(){
        SUtil.BootsRecipe(SMaterial.CACTUS_BOOTS, SMaterial.CACTUS);
    }
}