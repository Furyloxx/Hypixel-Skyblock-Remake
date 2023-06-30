package me.adarsh.godspunkycore.features.item.armor.glacite;

import me.adarsh.godspunkycore.features.item.*;

public class GlaciteHelmet implements MaterialFunction, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Glacite Helmet";
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
    public SpecificItemType getSpecificType() {
        return SpecificItemType.HELMET;
    }

    @Override
    public double getBaseDefense() {
        return 70;
    }

    @Override
    public double getBaseSpeed() {
        return 0.10;
    }

}
