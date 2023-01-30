package me.adarsh.godspunkycore.item.oddities;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.MaterialStatistics;
import me.adarsh.godspunkycore.item.Rarity;

public class Bedrock implements MaterialStatistics, MaterialFunction
{
    @Override
    public String getDisplayName()
    {
        return "Bedrock";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.BLOCK;
    }

    @Override
    public String getLore()
    {
        return "How do you have this??";
    }
}