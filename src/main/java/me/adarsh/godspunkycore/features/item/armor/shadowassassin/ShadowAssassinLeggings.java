package me.adarsh.godspunkycore.features.item.armor.shadowassassin;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class ShadowAssassinLeggings implements LeatherArmorStatistics, MaterialFunction {

    @Override
    public String getDisplayName() {
        return "Shadow Assassin Leggings";
    }

    @Override
    public double getBaseStrength() {
        return 25;
    }

    @Override
    public double getBaseCritDamage() {
        return 0.25;
    }

    @Override
    public double getBaseHealth() {
        return 210;
    }

    @Override
    public double getBaseDefense() {
        return 95;
    }

    @Override
    public double getBaseSpeed() {
        return 0.07;
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
        return 0x000000;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.LEGGINGS;
    }
}