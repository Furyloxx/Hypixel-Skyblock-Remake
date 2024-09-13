package me.godspunky.skyblock.features.item.armor.admin;

import me.godspunky.skyblock.features.item.*;

public class Anubis implements MaterialFunction, SkullStatistics, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Anubis";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ADMIN;
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
    public double getBaseHealth() {
        return 3001;
    }

    @Override
    public String getURL() {
        return "4ca69fcee8ae9a9384533eb95f64474be505910d959ff4ac12611b3017e079d0";
    }
}