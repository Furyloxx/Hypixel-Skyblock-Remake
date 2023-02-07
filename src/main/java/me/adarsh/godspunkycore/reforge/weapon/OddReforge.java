package me.adarsh.godspunkycore.reforge.weapon;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.RarityValue;
import me.adarsh.godspunkycore.reforge.Reforge;

import java.util.Collections;
import java.util.List;

public class OddReforge implements Reforge
{
    @Override
    public String getName()
    {
        return "Odd";
    }

    @Override
    public RarityValue<Double> getCritChance()
    {
        return new RarityValue<>(0.12, 0.15, 0.15, 0.2, 0.25, 0.25);
    }

    @Override
    public RarityValue<Double> getCritDamage()
    {
        return new RarityValue<>(0.1, 0.15, 0.15, 0.22, 0.3, 0.3);
    }

    @Override
    public RarityValue<Double> getIntelligence()
    {
        return new RarityValue<>(-5.0, -10.0, -18.0, -32.0, -50.0, -50.0);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes()
    {
        return Collections.singletonList(GenericItemType.WEAPON);
    }
}