package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class GlacialScythe implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Glacial Scythe";
    }

    @Override
    public int getBaseDamage() {
        return 120;
    }

    @Override
    public double getBaseIntelligence() {
        return 30;
    }

    @Override
    public int getManaCost() {
        return 75;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public String getAbilityName() {
        return "Ice Bolt";
    }

    @Override
    public String getAbilityDescription() {
        return "Shoots 1 Ice Bolt that deals 1,500 damage and slows enemies hit for 5 seconds! When hitting the ground, also creates an explosion of 3 blocks, dealing the same damage.";
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
