package me.godspunky.skyblock.features.item.armor.magma;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class MagmaBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Armor of Magma Boots";
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
        return SpecificItemType.BOOTS;
    }

    @Override
    public double getBaseHealth(){return 45;}

    @Override
    public double getBaseDefense() {
        return 15;
    }

    @Override
    public int getColor() {
        return 0xFF9300;
    }

    @Override
    public void load() {
        SUtil.BootsRecipe(SMaterial.MAGMA_BOOTS,SMaterial.ENCHANTED_MAGMA_CREAM,12);
    }
}

