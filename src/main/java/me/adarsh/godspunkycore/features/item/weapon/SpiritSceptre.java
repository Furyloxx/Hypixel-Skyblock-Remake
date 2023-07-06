package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class SpiritSceptre implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Spirit Sceptre";
    }

    @Override
    public int getBaseDamage() {
        return 180;
    }

    @Override
    public double getBaseIntelligence(){return 300;}

    @Override
    public int getManaCost() {
        return 200;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public String getAbilityName() {
        return "Guided Bat";
    }

    @Override
    public String getAbilityDescription() {
        return "Shoots a guided spirit bat, following your aim and exploding for 2,000 damage.";
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
