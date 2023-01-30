package me.adarsh.godspunkycore.item.dragon.strong;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SpecificItemType;
import me.adarsh.godspunkycore.item.armor.LeatherArmorStatistics;

public class StrongDragonLeggings implements MaterialFunction, LeatherArmorStatistics
{
    @Override
    public double getBaseStrength()
    {
        return 25;
    }

    @Override
    public double getBaseHealth()
    {
        return 100;
    }

    @Override
    public double getBaseDefense()
    {
        return 140;
    }

    @Override
    public int getColor()
    {
        return 0xE09419;
    }

    @Override
    public String getDisplayName()
    {
        return "Strong Dragon Leggings";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public String getLore()
    {
        return null;
    }
}