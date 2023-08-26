package me.godspunky.skyblock.features.item.armor.speedster;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class SpeedsterHelmet implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.HELMET;
    }

    @Override
    public double getBaseSpeed() {
        return 0.15;
    }

    @Override
    public double getBaseDefense() {
        return 70;
    }

    @Override
    public String getDisplayName() {
        return "Speedster Helmet";
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
        SUtil.HelmetRecipe(SMaterial.SPEEDSTER_HELMET,SMaterial.ENCHANTED_SUGARCANE);
    }
}

