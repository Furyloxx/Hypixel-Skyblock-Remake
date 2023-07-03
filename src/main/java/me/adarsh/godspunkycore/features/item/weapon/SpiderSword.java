package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class SpiderSword implements ToolStatistics, MaterialFunction {

    @Override
    public String getDisplayName() {
        return "Spider Sword";
    }

    @Override
    public int getBaseDamage() {
        return 30;
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
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

