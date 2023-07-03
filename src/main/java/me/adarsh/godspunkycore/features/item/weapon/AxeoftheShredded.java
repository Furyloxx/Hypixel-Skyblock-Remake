package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class AxeoftheShredded implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Axe of the Shredded";
    }

    @Override
    public int getBaseDamage() {
        return 140;
    }

    @Override
    public double getBaseStrength() {
        return 115;
    }

    @Override
    public int getManaCost() {
        return 20;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public String getAbilityName() {
        return "Throw";
    }

    @Override
    public String getAbilityDescription() {
        return "Throw your axe damaging all enemies in its path dealing 10% melee damage. Consecutive throws stack 2x damage but cost 2x mana up to 16x";
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
