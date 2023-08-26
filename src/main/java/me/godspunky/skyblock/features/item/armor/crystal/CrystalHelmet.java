package me.godspunky.skyblock.features.item.armor.crystal;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class CrystalHelmet implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Crystal Helmet";
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
        return SpecificItemType.HELMET;
    }

    @Override
    public double getBaseIntelligence(){return 0.65;}

    @Override
    public double getBaseDefense() {
        return 20;
    }

    @Override
    public int getColor() {
        return 0xFFFFFF;
    }

    @Override
    public void load() {
        SUtil.HelmetRecipe(SMaterial.CRYSTAL_HELMET,SMaterial.CRYSTAL_FRAGMENT);
    }
}

