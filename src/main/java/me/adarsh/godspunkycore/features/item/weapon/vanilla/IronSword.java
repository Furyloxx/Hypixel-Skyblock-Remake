package me.adarsh.godspunkycore.features.item.weapon.vanilla;

import me.adarsh.godspunkycore.features.item.*;

public class IronSword implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Iron Sword";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public int getBaseDamage() {
        return 30;
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