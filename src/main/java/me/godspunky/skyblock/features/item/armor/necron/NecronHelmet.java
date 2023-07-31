package me.godspunky.skyblock.features.item.armor.necron;

import me.godspunky.skyblock.features.item.*;

public class NecronHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Necron's Helmet";
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
    public double getBaseStrength() {
        return 40;
    }

    @Override
    public double getBaseCritDamage() {
        return 0.30;
    }

    @Override
    public double getBaseIntelligence() {
        return 30;
    }

    @Override
    public double getBaseHealth() {
        return 180;
    }

    @Override
    public double getBaseDefense() {
        return 100;
    }

    @Override
    public String getURL() {
        return "27883b9d824ff4988677cf062b08a2cc3f47714836a265320684f22a0d240283";
    }
}
