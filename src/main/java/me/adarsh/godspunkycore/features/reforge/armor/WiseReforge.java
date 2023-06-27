package me.adarsh.godspunkycore.features.reforge.armor;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.RarityValue;
import me.adarsh.godspunkycore.features.reforge.Reforge;

import java.util.Collections;
import java.util.List;

public class WiseReforge implements Reforge {
    @Override
    public String getName() {
        return "Wise";
    }

    @Override
    public RarityValue<Double> getIntelligence() {
        return new RarityValue<>(25.0, 50.0, 75.0, 100.0, 125.0, 150.0);
    }

    @Override
    public RarityValue<Double> getHealth() {
        return new RarityValue<>(6.0, 8.0, 10.0, 12.0, 15.0, 20.0);
    }

    @Override
    public RarityValue<Double> getSpeed() {
        return new RarityValue<>(0.01, 0.01, 0.01, 0.02, 0.02, 0.03);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.ARMOR);
    }
}
