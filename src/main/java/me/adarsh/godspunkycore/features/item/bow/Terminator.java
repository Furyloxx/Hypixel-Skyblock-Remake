package me.adarsh.godspunkycore.features.item.bow;

import me.adarsh.godspunkycore.features.item.*;

public class Terminator implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Juju Shortbow";
    }

    @Override
    public int getBaseDamage() {
        return 310;
    }

    @Override
    public double getBaseStrength() {
        return 50;
    }

    @Override
    public double getBaseCritDamage() {
        return 2.50;
    }

    @Override
    public String getAbilityName() {
        return "Salvation";
    }

    @Override
    public String getAbilityDescription() {
        return "Can be casted after landing 3 hits. Shoot a beam, penetrating up to 5 foes and dealing 2x the damage an arrow would.";
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
