package me.adarsh.godspunkycore.reforge.weapon;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.RarityValue;
import me.adarsh.godspunkycore.reforge.Reforge;

import java.util.Collections;
import java.util.List;

public class LegendaryReforge implements Reforge {
    @Override
    public String getName() {
        return "Legendary";
    }

    @Override
    public RarityValue<Double> getStrength() {
        return new RarityValue<>(3.0,7.0,12.0,18.0,25.0,32.0);
    }

    @Override
    public RarityValue<Double> getCritChance() {
        return new RarityValue<>(0.05,0.07,0.09,0.12,0.15,0.18);
    }

    @Override
    public RarityValue<Double> getCritDamage() {
        return new RarityValue<>(0.05,0.10,0.15,0.22,0.28,0.36);
    }

    @Override
    public RarityValue<Double> getIntelligence() {
        return new RarityValue<>(5.0,8.0,12.0,18.0,25.0,35.0);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.WEAPON);
    }
}
