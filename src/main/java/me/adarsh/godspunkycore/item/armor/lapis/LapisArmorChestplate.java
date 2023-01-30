package me.adarsh.godspunkycore.item.armor.lapis;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SpecificItemType;
import me.adarsh.godspunkycore.item.armor.LeatherArmorStatistics;

public class LapisArmorChestplate implements LeatherArmorStatistics, MaterialFunction
{
    @Override
    public String getDisplayName()
    {
        return "Lapis Armor Chestplate";
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
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public double getBaseDefense()
    {
        return 40;
    }

    @Override
    public int getColor()
    {
        return 0x0000FF;
    }
}