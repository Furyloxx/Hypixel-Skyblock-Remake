package me.adarsh.godspunkycore.item.oddities;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.MaterialStatistics;
import me.adarsh.godspunkycore.item.Rarity;

public class WeakWolfCatalyst implements MaterialStatistics, MaterialFunction
{
    @Override
    public String getDisplayName()
    {
        return "Weak Wolf Catalyst";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ITEM;
    }

    @Override
    public boolean isEnchanted()
    {
        return true;
    }
}
