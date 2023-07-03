package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class MidasStaff implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Midas's Staff";
    }

    @Override
    public int getBaseDamage() {
        return 130;
    }

    @Override
    public double getBaseStrength() {
        return 150;
    }

    @Override
    public double getBaseIntelligence() {
        return 50;
    }

    @Override
    public int getManaCost() {
        return 500;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 20;
    }

    @Override
    public String getAbilityName() {
        return "Molten Wave";
    }

    @Override
    public String getAbilityDescription() {
        return "Cast a wave of molten gold in the direction you are facing! Deals up to 6,000 - 32,000 damage.";
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
