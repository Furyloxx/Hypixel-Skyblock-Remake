package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class NecronsBlade implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Necron's Blade";
    }

    @Override
    public int getBaseDamage() {
        return 260;
    }

    @Override
    public double getBaseStrength() {
        return 110;
    }

    @Override
    public double getBaseIntelligence() {
        return 50;
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public String getAbilityName() {
        return null;
    }

    @Override
    public String getAbilityDescription() {
        return null;
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