package me.godspunky.skyblock.features.item.armor.mastiff;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class MastiffHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Mastiff Helmet";
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
    public double getBaseIntelligence() {
        return 125;
    }

    @Override
    public double getBaseDefense() {
        return -1000000;
    }

    @Override
    public double getBaseHealth() {
        return 500;
    }

    @Override
    public String getURL() {
        return "3285950fd67858e76c439b0b5b87c69a6c52a4df936e224d843b14c22565949e";
    }
}
