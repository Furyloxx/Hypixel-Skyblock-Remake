package me.adarsh.godspunkycore.reforge.armor;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.RarityValue;
import me.adarsh.godspunkycore.reforge.Reforge;

import java.util.Collections;
import java.util.List;

public class PureReforge implements Reforge {
    @Override
    public String getName() {
        return "Pure";
    }

    @Override
    public RarityValue<Double> getStrength() {
        return new RarityValue<>(2.0,3.0,4.0,6.0,8.0,10.0);
    }

    @Override
    public RarityValue<Double> getCritChance() {
        return new RarityValue<>(0.02,0.04,0.06,0.08,0.10,0.12);
    }

    @Override
    public RarityValue<Double> getCritDamage() {
        return new RarityValue<>(0.02,0.03,0.04,0.06,0.08,0.08);
    }

    @Override
    public RarityValue<Double> getIntelligence() {
        return new RarityValue<>(2.0,3.0,4.0,6.0,8.0,10.0);
    }

    @Override
    public RarityValue<Double> getDefence() {
        return new RarityValue<>(2.0,3.0,4.0,6.0,8.0,10.0);
    }

    @Override
    public RarityValue<Double> getHealth() {
        return new RarityValue<>(2.0,3.0,4.0,6.0,8.0,10.0);
    }

    @Override
    public RarityValue<Double> getSpeed() {
        return new RarityValue<>(0.01,0.01,0.01,0.01,0.01,0.01);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.ARMOR);
    }
}
