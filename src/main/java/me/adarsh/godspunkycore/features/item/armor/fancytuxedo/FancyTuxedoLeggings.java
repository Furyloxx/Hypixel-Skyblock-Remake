package me.adarsh.godspunkycore.features.item.armor.fancytuxedo;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class FancyTuxedoLeggings implements MaterialFunction, LeatherArmorStatistics {
    @Override
    public String getDisplayName() {
        return "Fancy Tuxedo Leggings";
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
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public double getBaseCritDamage() {
        return 35;
    }

    @Override
    public double getBaseIntelligence() {
        return 75;
    }

    @Override
    public int getColor() {
        return 0xD4D4D4;
    }
}
