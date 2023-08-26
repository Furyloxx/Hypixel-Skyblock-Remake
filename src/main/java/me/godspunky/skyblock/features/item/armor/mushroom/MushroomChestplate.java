package me.godspunky.skyblock.features.item.armor.mushroom;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class MushroomChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseHealth() {
        return 10;
    }

    @Override
    public double getBaseDefense() {
        return 10;
    }

    @Override
    public String getDisplayName() {
        return "Mushroom Chestplate";
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
        return 0xFF0000;
    }

    @Override
    public void load(){
        SUtil.ChestplateRecipe(SMaterial.MUSHROOM_CHESTPLATE, SMaterial.RED_MUSHROOM);
    }
}
