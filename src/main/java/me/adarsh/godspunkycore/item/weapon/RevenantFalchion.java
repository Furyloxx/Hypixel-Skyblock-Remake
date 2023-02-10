package me.adarsh.godspunkycore.item.weapon;

import me.adarsh.godspunkycore.item.*;

public class RevenantFalchion implements ToolStatistics, MaterialFunction, Ability
{
    @Override
    public String getAbilityName()
    {
        return null;
    }

    @Override
    public String getAbilityDescription()
    {
        return "Deals +150% damage against Zombies.";
    }


    @Override
    public int getAbilityCooldownTicks()
    {
        return 0;
    }

    @Override
    public int getManaCost()
    {
        return 0;
    }

    @Override
    public String getDisplayName()
    {
        return "Revenant Falchion";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.SWORD;
    }

    @Override
    public int getBaseDamage()
    {
        return 150;
    }
}
