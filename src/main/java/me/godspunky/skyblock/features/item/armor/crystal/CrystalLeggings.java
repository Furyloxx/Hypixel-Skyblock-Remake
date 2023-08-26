package me.godspunky.skyblock.features.item.armor.crystal;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class CrystalLeggings implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Crystal Leggings";
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
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public double getBaseIntelligence(){return 0.100;}

    @Override
    public double getBaseDefense() {
        return 30;
    }

    @Override
    public int getColor() {
        return 0xFFFFFF;
    }

    @Override
    public void load() {
        SUtil.LeggingsRecipe(SMaterial.CRYSTAL_LEGGINGS,SMaterial.CRYSTAL_FRAGMENT);
    }
}
