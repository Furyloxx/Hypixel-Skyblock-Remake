package me.adarsh.godspunkycore.item.dragon.old;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SpecificItemType;
import me.adarsh.godspunkycore.item.armor.LeatherArmorStatistics;

public class OldDragonBoots implements MaterialFunction, LeatherArmorStatistics
{
    @Override
    public double getBaseHealth()
    {
        return 80;
    }

    @Override
    public double getBaseDefense()
    {
        return 90;
    }

    @Override
    public int getColor()
    {
        return 0xF0E6AA;
    }

    @Override
    public String getDisplayName()
    {
        return "Old Dragon Boots";
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
        return SpecificItemType.BOOTS;
    }

    @Override
    public String getLore()
    {
        return null;
    }
}