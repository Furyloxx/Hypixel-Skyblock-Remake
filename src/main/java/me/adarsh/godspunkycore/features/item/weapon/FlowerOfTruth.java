package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class FlowerOfTruth implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Flower Of Truth";
    }

    @Override
    public int getBaseDamage() {
        return 160;
    }

    @Override
    public double getBaseStrength() {
        return 300;
    }

    @Override
    public double getBaseCritDamage() {
        return 0.3;
    }

    @Override
    public int getManaCost() {
        return 10;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 20;
    }

    @Override
    public String getAbilityName() {
        return "Heat-Seeking Rose";
    }

    @Override
    public String getAbilityDescription() {
        return "Shoots a rose that ricochets between enemies, damaging up to 3 of your foes! Damage multiplies as more enemies are hit.";
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

