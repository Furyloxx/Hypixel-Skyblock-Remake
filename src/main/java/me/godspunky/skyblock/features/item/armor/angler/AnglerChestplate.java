package me.godspunky.skyblock.features.item.armor.angler;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class AnglerChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 40;
    }

    @Override
    public String getDisplayName() {
        return "Angler Chestplate";
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
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public int getColor() {
        return 0x0B004F;
    }

    @Override
    public void load(){
        SUtil.ChestplateRecipe(SMaterial.ANGLER_CHESTPLATE, SMaterial.RAW_FISH);
    }
}
