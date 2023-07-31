package me.godspunky.skyblock.features.item.armor.tarantula;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class TarantulaBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.BOOTS;
    }

    @Override
    public double getBaseDefense() {
        return 100;
    }

    @Override
    public double getBaseSpeed() {
        return 0.5;
    }

    @Override
    public double getBaseHealth() {
        return 70;
    }

    @Override
    public double getBaseIntelligence() {
        return 0.50;
    }

    @Override
    public String getDisplayName() {
        return "Tarantula Boots";
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
        return 0x000000;
    }
}
