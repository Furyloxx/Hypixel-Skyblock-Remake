package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class ShadowFury implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Shadow Fury";
    }

    @Override
    public int getBaseDamage() {
        return 300;
    }

    @Override
    public double getBaseStrength() {
        return 130;
    }

    @Override
    public double getBaseCritDamage() {
        return 0.3;
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 300;
    }

    @Override
    public String getAbilityName() {
        return "Shadow Fury";
    }

    @Override
    public String getAbilityDescription() {
        return "Rapidly teleports you to up to 5 enemies within 12 blocks, rooting each of them and allowing you to hit them.";
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
        return null;
    }
}
