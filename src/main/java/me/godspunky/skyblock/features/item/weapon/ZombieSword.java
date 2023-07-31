package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class ZombieSword implements ToolStatistics, MaterialFunction, Ability {
    @Override
    public int getBaseDamage() {
        return 100;
    }
    @Override
    public double getBaseStrength() {
        return 50;
    }
    @Override
    public double getBaseIntelligence() {
        return 50;
    }

    @Override
    public String getDisplayName() {
        return "Zombie Sword";
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
    public String getAbilityName() {
        return "Instant Heal";
    }

    @Override
    public String getAbilityDescription() {
        return "Heal yourself for 120 + 5% max ❤ Health and Players within 7 blocks for 40 ❤.";
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 300;
    }

    @Override
    public int getManaCost() {
        return 70;
    }

}

