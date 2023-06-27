package me.adarsh.godspunkycore.features.item.armor.shadowassassin;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class ShadowAssassinBoots implements LeatherArmorStatistics, MaterialFunction {

    @Override
    public String getDisplayName() {
        return "Shadow Assassin Boots";
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
        return 125;
    }

    @Override
    public double getBaseDefense() {
        return 55;
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
        return SpecificItemType.BOOTS;
    }
}