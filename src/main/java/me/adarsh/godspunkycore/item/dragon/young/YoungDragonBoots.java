package me.adarsh.godspunkycore.item.dragon.young;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SpecificItemType;
import me.adarsh.godspunkycore.item.armor.LeatherArmorStatistics;

public class YoungDragonBoots implements MaterialFunction, LeatherArmorStatistics
{
    @Override
    public double getBaseSpeed()
    {
        return 0.2;
    }

    @Override
    public double getBaseHealth()
    {
        return 60;
    }

    @Override
    public double getBaseDefense()
    {
        return 90;
    }

    @Override
    public int getColor()
    {
        return 0xDDE4F0;
    }

    @Override
    public String getDisplayName()
    {
        return "Young Dragon Boots";
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