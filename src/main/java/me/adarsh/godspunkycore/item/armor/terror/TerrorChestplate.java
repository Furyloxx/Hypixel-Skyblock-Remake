package me.adarsh.godspunkycore.item.armor.terror;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SpecificItemType;
import me.adarsh.godspunkycore.item.armor.LeatherArmorStatistics;

public class TerrorChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseCritDamage() {
        return 0.50;
    }

    @Override
    public double getBaseIntelligence() {
        return 5;
    }

    @Override
    public double getBaseSpeed() {
        return 0.12;
    }

    @Override
    public double getBaseHealth() {
        return 230;
    }

    @Override
    public double getBaseDefense() {
        return 65;
    }

    @Override
    public String getDisplayName() {
        return "Terror Chestplate";
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
        return 0x290064;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.CHESTPLATE;
    }
}
