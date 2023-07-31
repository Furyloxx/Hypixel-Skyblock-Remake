package me.godspunky.skyblock.features.item.armor.glacite;

import me.godspunky.skyblock.features.item.*;

public class GlaciteHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
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

    @Override
    public String getURL() {
        return "56aab58fa01fce9af469ed747aed811d7ba18c476f5a7f9088e129c31b45f3";
    }

}
