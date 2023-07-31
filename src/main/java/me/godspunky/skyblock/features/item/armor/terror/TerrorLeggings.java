package me.godspunky.skyblock.features.item.armor.terror;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class TerrorLeggings implements LeatherArmorStatistics, MaterialFunction {

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public double getBaseStrength() {
        return 55;
    }

    @Override
    public double getBaseCritDamage() {
        return 0.50;
    }


    @Override
    public double getBaseIntelligence() {
        return 5;
    }

    @Override
    public double getBaseHealth() {
        return 205;
    }

    @Override
    public double getBaseDefense() {
        return 55;
    }

    @Override
    public double getBaseSpeed() {
        return 0.12;
    }

    @Override
    public String getDisplayName() {
        return "Terror Leggings";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public int getColor() {
        return 0xA020F0;
    }

}
