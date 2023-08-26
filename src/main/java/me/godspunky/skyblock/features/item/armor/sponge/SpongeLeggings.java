package me.godspunky.skyblock.features.item.armor.sponge;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class SpongeLeggings implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public double getBaseDefense() {
        return 100;
    }

    @Override
    public String getDisplayName() {
        return "Sponge Leggings";
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
        SUtil.LeggingsRecipe(SMaterial.SPONGE_LEGGINGS,SMaterial.ENCHANTED_WET_SPONGE);
    }
}
