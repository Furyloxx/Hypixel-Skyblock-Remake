package me.adarsh.godspunkycore.features.reforge.weapon;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.RarityValue;
import me.adarsh.godspunkycore.features.reforge.Reforge;

import java.util.Collections;
import java.util.List;

public class SpicyReforge implements Reforge {
    @Override
    public String getName() {
        return "Spicy";
    }

    @Override
    public RarityValue<Double> getStrength() {
        return new RarityValue<>(2.0, 3.0, 4.0, 7.0, 10.0, 12.0);
    }

    @Override
    public RarityValue<Double> getCritChance() {
        return RarityValue.singleDouble(0.01);
    }

    @Override
    public RarityValue<Double> getCritDamage() {
        return new RarityValue<>(0.25, 0.35, 0.45, 0.6, 0.8, 1.0);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.WEAPON);
    }
}