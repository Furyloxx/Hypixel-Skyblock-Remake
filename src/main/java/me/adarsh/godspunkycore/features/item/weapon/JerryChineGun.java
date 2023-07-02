package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class JerryChineGun implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Jerry Chine Gun";
    }

    @Override
    public int getBaseDamage() {
        return 80;
    }

    @Override
    public double getBaseIntelligence() {
        return 200;
    }

    @Override
    public int getManaCost() {
        return 30;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 80;
    }

    @Override
    public String getAbilityName() {
        return "Rapid-fire";
    }

    @Override
    public String getAbilityDescription() {
        return "Shoots a Jerry bullet, dealing 500+ damage on impact and knocking you back.";
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