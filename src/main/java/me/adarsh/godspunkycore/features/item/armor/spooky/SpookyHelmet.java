package me.adarsh.godspunkycore.features.item.armor.spooky;

import me.adarsh.godspunkycore.features.item.*;

public class SpookyHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Spooky Helmet";
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
        return 25;
    }

    @Override
    public String getURL() {
        return "4c6570f1242992f6eba23ee582598c39e3e745383273deef8b3977583fe3cf5";
    }

}
