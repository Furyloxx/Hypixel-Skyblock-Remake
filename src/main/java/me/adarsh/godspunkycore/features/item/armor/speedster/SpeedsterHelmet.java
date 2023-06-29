package me.adarsh.godspunkycore.features.item.armor.speedster;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

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
}

