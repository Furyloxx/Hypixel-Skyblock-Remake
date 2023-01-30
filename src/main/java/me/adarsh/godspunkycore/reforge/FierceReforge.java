package me.adarsh.godspunkycore.reforge;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.RarityValue;

import java.util.Collections;
import java.util.List;

public class FierceReforge implements Reforge
{
    @Override
    public String getName()
    {
        return "Fierce";
    }

    @Override
    public RarityValue<Double> getStrength()
    {
        return new RarityValue<>(2.0, 4.0, 6.0, 8.0, 10.0, 12.0);
    }

    @Override
    public RarityValue<Double> getCritChance()
    {
        return new RarityValue<>(0.02, 0.03, 0.04, 0.05, 0.06, 0.08);
    }

    @Override
    public RarityValue<Double> getCritDamage()
    {
        return new RarityValue<>(0.04, 0.07, 0.1, 0.14, 0.18, 0.24);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes()
    {
        return Collections.singletonList(GenericItemType.ARMOR);
    }
}