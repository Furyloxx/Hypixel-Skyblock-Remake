package me.godspunky.skyblock.features.item.armor.sponge;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class SpongeBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.BOOTS;
    }

    @Override
    public double getBaseDefense() {
        return 60;
    }

    @Override
    public String getDisplayName() {
        return "Sponge Boots";
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
        SUtil.BootsRecipe(SMaterial.SPONGE_BOOTS,SMaterial.ENCHANTED_WET_SPONGE);
    }
}

