package me.adarsh.godspunkycore.features.item.bow;

import me.adarsh.godspunkycore.features.item.*;

public class ExplosiveBow implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Explosive Bow";
    }

    @Override
    public int getBaseDamage() {
        return 100;
    }

    @Override
    public double getBaseStrength() {
        return 20;
    }

    @Override
    public String getAbilityName() {
        return "Explosive Shot";
    }

    @Override
    public String getAbilityDescription() {
        return "Creates an explosion on impact! Every Monster caught in this explosion takes the full damage of the weapon!";
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.RANGED_WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.BOW;
    }
}