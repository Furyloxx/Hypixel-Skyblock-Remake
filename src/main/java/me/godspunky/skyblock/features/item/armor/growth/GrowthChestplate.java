package me.godspunky.skyblock.features.item.armor.growth;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class GrowthChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 50;
    }

    @Override
    public double getBaseHealth(){return 100;}

    @Override
    public String getDisplayName() {
        return "Chestplate of Growth";
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
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public void load() {
        SUtil.ChestplateRecipe(SMaterial.GROWTH_CHESTPLATE,SMaterial.ENCHANTED_DARK_OAK_WOOD,64);
    }
}

