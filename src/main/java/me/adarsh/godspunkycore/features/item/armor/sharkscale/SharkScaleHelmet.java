package me.adarsh.godspunkycore.features.item.armor.sharkscale;

import me.adarsh.godspunkycore.features.item.*;

public class SharkScaleHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Shark Scale Helmet";
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
    public double getBaseDefense() {
        return 120;
    }

    @Override
    public double getBaseHealth() {
        return 120;
    }

    @Override
    public String getURL() {
        return "20a5bb07164739a2fc64e21b629c999fd05a31399909851084bea2a0c7fc24bd";
    }
}