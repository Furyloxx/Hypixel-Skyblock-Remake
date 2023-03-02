package me.adarsh.godspunkycore.item.weapon;

import me.adarsh.godspunkycore.item.*;

public class Exterminator implements ToolStatistics, MaterialFunction {
    @Override
    public int getBaseDamage() {
        return 100000;
    }

    @Override
    public double getBaseStrength() {
        return 100000;
    }

    @Override
    public double getBaseCritDamage() {
        return 100000.0;
    }

    @Override
    public String getDisplayName() {
        return "Exterminator";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EXCLUSIVE;
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