package me.adarsh.godspunkycore.item.tarantula;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.MaterialStatistics;
import me.adarsh.godspunkycore.item.Rarity;

public class DigestedMosquito implements MaterialStatistics, MaterialFunction
{
    @Override
    public String getDisplayName()
    {
        return "Digested Mosquito";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ITEM;
    }
}