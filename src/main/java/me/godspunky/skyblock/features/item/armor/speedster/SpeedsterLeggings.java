package me.godspunky.skyblock.features.item.armor.speedster;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class SpeedsterLeggings implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public double getBaseSpeed() {
        return 0.15;
    }

    @Override
    public double getBaseDefense() {
        return 95;
    }

    @Override
    public String getDisplayName() {
        return "Speedster Leggings";
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
        SUtil.LeggingsRecipe(SMaterial.SPEEDSTER_LEGGINGS,SMaterial.ENCHANTED_SUGARCANE);
    }
}
