package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class EdibleMace implements ToolStatistics, MaterialFunction, Ability {
    @Override
    public int getBaseDamage() {
        return 125;
    }

    @Override
    public double getBaseStrength() {
        return 25;
    }

    @Override
    public String getDisplayName() {
        return "Edible Mace";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
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

    @Override
    public String getAbilityName() {
        return "ME SMASH HEAD";
    }

    @Override
    public String getAbilityDescription() {
        return "Your next attack deals double ❁ Damage and weakens animals, making them deal -35% Damage for 30 seconds.";
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 600;
    }

    @Override
    public int getManaCost() {
        return 100;
    }

}
