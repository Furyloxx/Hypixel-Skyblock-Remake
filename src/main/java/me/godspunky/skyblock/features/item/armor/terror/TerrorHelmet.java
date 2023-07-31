package me.godspunky.skyblock.features.item.armor.terror;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class TerrorHelmet implements SkullStatistics, MaterialFunction, LeatherArmorStatistics {
    @Override
    public String getDisplayName() {
        return "Terror Helmet";
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
    public SpecificItemType getSpecificType() {
        return SpecificItemType.HELMET;
    }

    @Override
    public String getURL() {
        return "52af8833697c81b46e83c8f1895266e606efbb3a59f1c3b4ca2816da2bcfa9d6";
    }

    @Override
    public double getBaseCritDamage() {
        return 0.50;
    }

    @Override
    public double getBaseIntelligence() {
        return 15;
    }

    @Override
    public double getBaseSpeed() {
        return 0.12;
    }

    @Override
    public double getBaseHealth() {
        return 150;
    }

    @Override
    public double getBaseDefense() {
        return 50;
    }

    @Override
    public int getColor() {
        return 0x000000;
    }
}
