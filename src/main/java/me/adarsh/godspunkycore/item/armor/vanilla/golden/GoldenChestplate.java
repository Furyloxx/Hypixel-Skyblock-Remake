package me.adarsh.godspunkycore.item.armor.vanilla.golden;

import me.adarsh.godspunkycore.item.*;

public class GoldenChestplate implements ToolStatistics, MaterialFunction
{
    @Override
    public String getDisplayName()
    {
        return "Golden Chestplate";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public double getBaseDefense()
    {
        return 25;
    }
}
