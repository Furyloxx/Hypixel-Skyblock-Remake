package me.godspunky.skyblock.features.item.armor.sponge;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class SpongeChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public double getBaseDefense() {
        return 145;
    }

    @Override
    public String getDisplayName() {
        return "Sponge Chestplate";
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
        return 0xFFDC51;
    }

    @Override
    public void load() {
        SUtil.ChestplateRecipe(SMaterial.SPONGE_CHESTPLATE,SMaterial.ENCHANTED_WET_SPONGE);
    }
}
