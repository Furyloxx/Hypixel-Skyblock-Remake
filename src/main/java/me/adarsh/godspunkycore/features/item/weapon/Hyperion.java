package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;
public class Hyperion implements ToolStatistics, MaterialFunction {

    @Override
    public int getBaseDamage() {
        return 260;
    }

    @Override
    public double getBaseStrength() {
        return 150;
    }

    @Override
    public String getDisplayName() {
        return "Hyperion";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }

    @Override
    public String getLore() {
        return "";
    }

    @Override
    public double getBaseIntelligence() {
        return 350;
    }
}
