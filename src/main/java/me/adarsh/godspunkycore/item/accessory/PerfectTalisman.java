package me.adarsh.godspunkycore.item.accessory;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SpecificItemType;

public class PerfectTalisman implements AccessoryStatistics, MaterialFunction
{
    @Override
    public String getURL()
    {
        return "13e8bbc8d174aecd6b46888fa63f9bade14b042e5e17063139d67f8e0163a38";
    }

    @Override
    public String getDisplayName()
    {
        return "Perfect Talisman";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.EXCLUSIVE;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ACCESSORY;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.ACCESSORY;
    }

    @Override
    public double getBaseCritChance()
    {
        return 1.0;
    }

    @Override
    public double getBaseIntelligence()
    {
        return 800;
    }

    @Override
    public double getBaseStrength()
    {
        return 500;
    }

    @Override
    public double getBaseHealth()
    {
        return 300;
    }

    @Override
    public double getBaseDefense()
    {
        return 100;
    }

    @Override
    public double getBaseCritDamage()
    {
        return 1.5;
    }

    @Override
    public double getBaseSpeed()
    {
        return 2.0;
    }

    @Override
    public double getBaseMagicFind()
    {
        return 100.0;
    }
}