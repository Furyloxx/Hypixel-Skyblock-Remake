package me.godspunky.skyblock.features.item.armor.emerald;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class EmeraldBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.BOOTS;
    }

    @Override
    public double getBaseDefense() {
        return 45;
    }

    @Override
    public String getDisplayName() {
        return "Emerald Boots";
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
    public int getColor() {
        return 0x00FF00;
    }

    @Override
    public void load() {
        SUtil.BootsRecipe(SMaterial.EMERALD_BOOTS,SMaterial.ENCHANTED_EMERALD_BLOCK);
    }
}