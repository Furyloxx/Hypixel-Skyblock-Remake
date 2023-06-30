package me.adarsh.godspunkycore.features.item.armor.werewolf;

import me.adarsh.godspunkycore.features.item.*;

public class WerewolfHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Werewolf Helmet";
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
        return 135;
    }

    @Override
    public double getBaseIntelligence() {
        return 50;
    }

    @Override
    public String getURL() {
        return "ce4606c6d973a999aec1687c7e075f7d37db8185e88b844507f16b3e2b3eb690";
    }
}

