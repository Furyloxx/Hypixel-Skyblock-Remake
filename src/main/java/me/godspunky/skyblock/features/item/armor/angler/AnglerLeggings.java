package me.godspunky.skyblock.features.item.armor.angler;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class AnglerLeggings implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 30;
    }

    @Override
    public String getDisplayName() {
        return "Angler Leggings";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
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
    public int getColor() {
        return 0x0B004F;
    }

    @Override
    public void load(){
        SUtil.LeggingsRecipe(SMaterial.ANGLER_LEGGINGS, SMaterial.RAW_FISH);
    }
}
