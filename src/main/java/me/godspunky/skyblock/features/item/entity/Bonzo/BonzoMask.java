package me.godspunky.skyblock.features.item.entity.Bonzo;

import me.godspunky.skyblock.features.item.*;

public class BonzoMask implements SkullStatistics, MaterialFunction, ToolStatistics {
    @Override
    public String getURL() {
        return "12716ecbf5b8da00b05f316ec6af61e8bd02805b21eb8e440151468dc656549c";
    }

    @Override
    public String getDisplayName() {
        return "Bonzo's Mask";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public double getBaseHealth(){return 100;}

    @Override
    public double getBaseDefense() {
        return 100;
    }

    @Override
    public double getBaseIntelligence() {
        return 100;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.HELMET;
    }
}
