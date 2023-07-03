package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class SoulWhip implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Soul Whip";
    }

    @Override
    public int getBaseDamage() {
        return 145;
    }

    @Override
    public double getBaseStrength() {
        return 175;
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
        return "Flay";
    }

    @Override
    public String getAbilityDescription() {
        return "Flay your whip in an arc, dealing your melee damage to all enemies in its path";
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
