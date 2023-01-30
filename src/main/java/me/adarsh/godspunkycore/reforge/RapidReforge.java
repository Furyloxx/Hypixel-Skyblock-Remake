package me.adarsh.godspunkycore.reforge;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.RarityValue;

import java.util.Collections;
import java.util.List;

public class RapidReforge implements Reforge
{
    @Override
    public String getName()
    {
        return "Rapid";
    }

    @Override
    public RarityValue<Double> getStrength()
    {
        return new RarityValue<>(2.0, 3.0, 4.0, 7.0, 10.0, 15.0);
    }

    @Override
    public RarityValue<Double> getCritDamage()
    {
        return new RarityValue<>(0.35, 0.45, 0.55, 0.65, 0.75, 0.9);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes()
    {
        return Collections.singletonList(GenericItemType.RANGED_WEAPON);
    }
}