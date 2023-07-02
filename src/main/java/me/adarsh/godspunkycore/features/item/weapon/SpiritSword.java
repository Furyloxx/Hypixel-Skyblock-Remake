package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class SpiritSword implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Spirit Sword";
    }

    @Override
    public int getBaseDamage() {
        return 210;
    }

    @Override
    public double getBaseStrength() {
        return 50;
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 200;
    }

    @Override
    public String getAbilityName() {
        return "Spirit Bomb";
    }

    @Override
    public String getAbilityDescription() {
        return "Shoot a Spirit that does 8000 Damage on impact!";
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
