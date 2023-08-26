package me.godspunky.skyblock.features.item.armor.speedster;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class SpeedsterChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public double getBaseSpeed() {
        return 0.15;
    }

    @Override
    public double getBaseDefense() {
        return 120;
    }

    @Override
    public String getDisplayName() {
        return "Speedster Chestplate";
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
        return 0xE0FCF7;
    }

    @Override
    public void load() {
        SUtil.ChestplateRecipe(SMaterial.SPEEDSTER_CHESTPLATE,SMaterial.ENCHANTED_SUGARCANE);
    }
}

