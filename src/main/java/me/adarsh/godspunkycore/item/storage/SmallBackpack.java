package me.adarsh.godspunkycore.item.storage;

import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SkullStatistics;

public class SmallBackpack extends Storage implements SkullStatistics
{
    @Override
    public int getSlots()
    {
        return 9;
    }

    @Override
    public String getDisplayName()
    {
        return "Small Backpack";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.UNCOMMON;
    }

    @Override
    public String getURL()
    {
        return "21d837ca222cbc0bc12426f5da018c3a931b406008800960a9df112a596e7d62";
    }
}