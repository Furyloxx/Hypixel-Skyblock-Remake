package me.adarsh.godspunkycore.features.item.armor.tarantula;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

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
