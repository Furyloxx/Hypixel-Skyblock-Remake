package me.adarsh.godspunkycore.reforge.armor;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.RarityValue;
import me.adarsh.godspunkycore.reforge.Reforge;

import java.util.Collections;
import java.util.List;

public class LightReforge implements Reforge {
    @Override
    public String getName() {
        return "Light";
    }

    @Override
    public RarityValue<Double> getCritChance() {
        return new RarityValue<>(0.01, 0.01, 0.02, 0.02, 0.03, 0.03);
    }

    @Override
    public RarityValue<Double> getCritDamage() {
        return new RarityValue<>(0.01, 0.02, 0.03, 0.04, 0.05, 0.06);
    }

    @Override
    public RarityValue<Double> getDefence() {
        return new RarityValue<>(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
    }

    @Override
    public RarityValue<Double> getHealth() {
        return new RarityValue<>(5.0, 7.0, 10.0, 15.0, 20.0, 25.0);
    }

    @Override
    public RarityValue<Double> getSpeed() {
        return new RarityValue<>(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.ARMOR);
    }
}
