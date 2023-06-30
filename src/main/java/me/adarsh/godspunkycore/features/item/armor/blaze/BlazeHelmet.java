package me.adarsh.godspunkycore.features.item.armor.blaze;

import me.adarsh.godspunkycore.features.item.*;

public class BlazeHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Blaze Helmet";
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
    public double getBaseSpeed() {
        return 0.2;
    }

    @Override
    public double getBaseStrength() {
        return 10;
    }

    @Override
    public double getBaseDefense() {
        return 80;
    }

    @Override
    public String getURL() {
        return "78fc823c1a13931230d662e36613b906eb14510a67375251078d5ffa3037dbab";
    }
}

