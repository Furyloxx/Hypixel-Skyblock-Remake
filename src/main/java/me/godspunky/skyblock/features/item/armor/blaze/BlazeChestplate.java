package me.godspunky.skyblock.features.item.armor.blaze;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class BlazeChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public double getBaseSpeed() {
        return 0.2;
    }

    @Override
    public double getBaseStrength() {
        return 10;
    }

    @Override
    public double getBaseDefense() {
        return 150;
    }

    @Override
    public String getDisplayName() {
        return "Blaze Chestplate";
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
        return 0xF7DA33;
    }

    @Override
    public void load() {
        SUtil.ChestplateRecipe(SMaterial.BLAZE_CHESTPLATE,SMaterial.ENCHANTED_BLAZE_ROD);
    }
}
