package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class PigmanSword implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Pigman Sword";
    }

    @Override
    public int getBaseDamage() {
        return 200;
    }

    @Override
    public double getBaseStrength() {
        return 100;
    }

    @Override
    public double getBaseCritChance() {
        return 0.5;
    }

    @Override
    public double getBaseCritDamage() {
        return 30;
    }

    @Override
    public double getBaseIntelligence() {
        return 300;
    }

    @Override
    public int getManaCost() {
        return 400;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 100;
    }

    @Override
    public String getAbilityName() {
        return "Burning Souls";
    }

    @Override
    public String getAbilityDescription() {
        return "Gain +300 ❈ Defense for 5s and cast vortex of flames towards enemies, dealing up to 30,000 damage over 5 second";
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

