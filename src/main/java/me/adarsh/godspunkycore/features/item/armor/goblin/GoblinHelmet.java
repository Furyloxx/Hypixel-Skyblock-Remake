package me.adarsh.godspunkycore.features.item.armor.goblin;

import me.adarsh.godspunkycore.features.item.*;

public class GoblinHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Goblin Helmet";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
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
        return -1;
    }

    @Override
    public double getBaseHealth() {
        return 70;
    }

    @Override
    public String getURL() {
        return "4bf56c6541c1266ffc463510bdb55aef9315af548898cf5d3cba1b5b4c01";
    }
}

