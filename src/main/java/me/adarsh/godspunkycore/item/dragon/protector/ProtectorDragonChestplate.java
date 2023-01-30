package me.adarsh.godspunkycore.item.dragon.protector;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SpecificItemType;
import me.adarsh.godspunkycore.item.armor.LeatherArmorStatistics;

public class ProtectorDragonChestplate implements MaterialFunction, LeatherArmorStatistics
{
    @Override
    public double getBaseHealth()
    {
        return 120;
    }

    @Override
    public double getBaseDefense()
    {
        return 185;
    }

    @Override
    public int getColor()
    {
        return 0x99978B;
    }

    @Override
    public String getDisplayName()
    {
        return "Protector Dragon Chestplate";
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
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public String getLore()
    {
        return null;
    }
}