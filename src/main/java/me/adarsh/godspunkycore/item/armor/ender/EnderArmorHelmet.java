package me.adarsh.godspunkycore.item.armor.ender;

import me.adarsh.godspunkycore.item.*;

public class EnderArmorHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
    @Override
    public String getURL() {
        return "f8c75dc583facc3455df35c2d5d555bb4a90e1049b0a2e7193ebbdd445688387";
    }

    @Override
    public double getBaseHealth() {
        return 20;
    }

    @Override
    public double getBaseDefense() {
        return 35;
    }

    @Override
    public String getDisplayName() {
        return "Ender Armor Helmet";
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
    public String getLore() {
        return null;
    }
}
