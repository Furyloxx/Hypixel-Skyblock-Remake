package me.godspunky.skyblock.features.item.armor.mushroom;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class MushroomLeggings implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseHealth() {
        return 10;
    }

    @Override
    public double getBaseDefense() {
        return 5;
    }

    @Override
    public String getDisplayName() {
        return "Mushroom Leggings";
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
        return 0xFF0000;
    }

    @Override
    public void load(){
        SUtil.HelmetRecipe(SMaterial.MUSHROOM_LEGGINGS, SMaterial.RED_MUSHROOM);
    }
}
