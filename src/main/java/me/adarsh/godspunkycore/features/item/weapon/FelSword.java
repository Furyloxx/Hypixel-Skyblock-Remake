package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class FelSword implements ToolStatistics, MaterialFunction {

    @Override
    public String getDisplayName() {
        return "Fel Sword";
    }

    @Override
    public int getBaseDamage() {
        return 190;
    }

    @Override
    public double getBaseStrength() {
        return 135;
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
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
