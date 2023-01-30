package me.adarsh.godspunkycore.item.armor.hardened;

import me.adarsh.godspunkycore.item.*;

public class HardenedDiamondHelmet implements ToolStatistics, MaterialFunction
{
    @Override
    public String getDisplayName()
    {
        return "Hardened Diamond Helmet";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.RARE;
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
        return 60;
    }
}