package me.adarsh.godspunkycore.features.item.bow;

import me.adarsh.godspunkycore.features.item.*;

public class MachineGunBow implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Machine Gun Bow";
    }

    @Override
    public int getBaseDamage() {
        return 75;
    }

    @Override
    public double getBaseStrength() {
        return 50;
    }

    @Override
    public double getBaseCritDamage() {
        return 1.2;
    }

    @Override
    public String getAbilityName() {
        return "Rapid Fire";
    }

    @Override
    public String getAbilityDescription() {
        return "Shoots 5 Arrows per second for 8 seconds! Arrows deal 70.0% of what they normally deal";
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 2000;
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
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
