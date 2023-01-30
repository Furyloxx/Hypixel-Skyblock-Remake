package me.adarsh.godspunkycore.item.accessory;

import me.adarsh.godspunkycore.item.*;

public interface AccessoryStatistics extends PlayerBoostStatistics, SkullStatistics, Reforgable
{
    @Override
    default GenericItemType getType()
    {
        return GenericItemType.ACCESSORY;
    }

    @Override
    default SpecificItemType getSpecificType()
    {
        return SpecificItemType.ACCESSORY;
    }
}