package me.adarsh.godspunkycore.features.item.bow;

import me.adarsh.godspunkycore.features.item.*;

public class EnderBow implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Ender Bow";
    }

    @Override
    public int getBaseDamage() {
        return 60;
    }

    @Override
    public String getAbilityName() {
        return "Ender Warp";
    }

    @Override
    public String getAbilityDescription() {
        return "Shoots an Ender Pearl. Upon landing you deal damage to all monster in a 8 block radius for 10% of their health.";
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 900;
    }

    @Override
    public int getManaCost() {
        return 50;
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
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