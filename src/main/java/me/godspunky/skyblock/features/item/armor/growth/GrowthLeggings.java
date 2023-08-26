package me.godspunky.skyblock.features.item.armor.growth;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class GrowthLeggings  implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 40;
    }

    @Override
    public double getBaseHealth(){return 80;}

    @Override
    public String getDisplayName() {
        return "Leggings of Growth";
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
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public void load() {
        SUtil.LeggingsRecipe(SMaterial.GROWTH_LEGGINGS,SMaterial.ENCHANTED_DARK_OAK_WOOD,64);
    }
}

