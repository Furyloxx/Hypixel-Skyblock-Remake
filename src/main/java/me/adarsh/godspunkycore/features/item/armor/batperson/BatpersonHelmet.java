package me.adarsh.godspunkycore.features.item.armor.batperson;

import me.adarsh.godspunkycore.features.item.*;

public class BatpersonHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Bat Person Helmet";
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
        return 15;
    }

    @Override
    public String getLore(){
        return null;
    }

    @Override
    public String getURL() {
        return "a83b3f04fc16bc2c2cb36a12044265b0b933f3dfa2b342eb45798ff7d715b0d8";
    }
}
