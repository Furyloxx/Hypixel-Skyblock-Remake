package me.adarsh.godspunkycore.item.weapon.vanilla;

import me.adarsh.godspunkycore.item.*;

public class StoneSword implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Stone Sword";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public int getBaseDamage() {
        return 25;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }
}