package me.adarsh.godspunkycore.reforge;

import me.adarsh.godspunkycore.item.RarityValue;

// sort of a test reforge
public class OverpoweredReforge implements Reforge
{
    @Override
    public String getName()
    {
        return "Overpowered";
    }

    @Override
    public RarityValue<Double> getStrength()
    {
        return RarityValue.singleDouble(1000.0);
    }

    @Override
    public RarityValue<Double> getCritChance()
    {
        return RarityValue.singleDouble(0.5);
    }

    @Override
    public RarityValue<Double> getCritDamage()
    {
        return RarityValue.singleDouble(2.0);
    }

    @Override
    public RarityValue<Double> getIntelligence()
    {
        return RarityValue.singleDouble(500.0);
    }
}
