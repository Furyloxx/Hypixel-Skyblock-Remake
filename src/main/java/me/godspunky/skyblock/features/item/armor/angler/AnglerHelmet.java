package me.godspunky.skyblock.features.item.armor.angler;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class AnglerHelmet implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 15;
    }

    @Override
    public String getDisplayName() {
        return "Angler Helmet";
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
        return SpecificItemType.HELMET;
    }

    @Override
    public int getColor() {
        return 0x0B004F;
    }

    @Override
    public void load(){
        SUtil.HelmetRecipe(SMaterial.ANGLER_HELMET, SMaterial.RAW_FISH);
    }
}
