package me.adarsh.godspunkycore.item.armor.vanilla.diamond;

import me.adarsh.godspunkycore.item.*;

public class DiamondHelmet implements ToolStatistics, MaterialFunction
{
    @Override
    public String getDisplayName()
    {
        return "Diamond Helmet";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.HELMET;
    }

    @Override
    public double getBaseDefense()
    {
        return 15;
    }
}
