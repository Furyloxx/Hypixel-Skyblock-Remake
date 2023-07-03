package me.adarsh.godspunkycore.features.item.bow;

import me.adarsh.godspunkycore.features.item.*;

public class SoulsRebound implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Soul Rebound";
    }

    @Override
    public int getBaseDamage() {
        return 450;
    }

    @Override
    public String getAbilityName() {
        return null;
    }

    @Override
    public String getAbilityDescription() {
            return null;
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