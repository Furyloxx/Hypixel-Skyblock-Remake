package me.adarsh.godspunkycore.reforge.armor;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.RarityValue;
import me.adarsh.godspunkycore.reforge.Reforge;

import java.util.Collections;
import java.util.List;

public class SmartReforge implements Reforge {
    @Override
    public String getName() {
        return "Smart";
    }

    @Override
    public RarityValue<Double> getIntelligence() {
        return new RarityValue<>(20.0,40.0,60.0,80.0,100.0,120.0);
    }

    @Override
    public RarityValue<Double> getDefence() {
        return new RarityValue<>(4.0,6.0,9.0,12.0,15.0,20.0);
    }

    @Override
    public RarityValue<Double> getHealth() {
        return new RarityValue<>(4.0,6.0,9.0,12.0,15.0,20.0);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.ARMOR);
    }
}
