package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class RaiderAxe implements ToolStatistics, MaterialFunction {

    @Override
    public int getBaseDamage() {
        return 115;
    }

    @Override
    public double getBaseStrength() {
        return 150;
    }

    @Override
    public String getDisplayName() {
        return "Raider Axe";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
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
        return null;
    }
}

