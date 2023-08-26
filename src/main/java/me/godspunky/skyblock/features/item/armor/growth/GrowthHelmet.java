package me.godspunky.skyblock.features.item.armor.growth;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class GrowthHelmet implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 30;
    }

    @Override
    public double getBaseHealth(){return 50;}

    @Override
    public String getDisplayName() {
        return "Helmet of Growth";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public int getColor() {
        return 0x00BE00;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.HELMET;
    }

    @Override
    public void load() {
        SUtil.HelmetRecipe(SMaterial.GROWTH_HELMET,SMaterial.ENCHANTED_DARK_OAK_WOOD,64);
    }
}

