package me.adarsh.godspunkycore.features.reforge.weapon;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.RarityValue;
import me.adarsh.godspunkycore.features.reforge.Reforge;

import java.util.Collections;
import java.util.List;

public class FairReforge implements Reforge {
    @Override
    public String getName() {
        return "Fair";
    }

    @Override
    public RarityValue<Double> getStrength() {
        return new RarityValue<>(2.0, 3.0, 4.0, 7.0, 10.0, 12.0);
    }

    @Override
    public RarityValue<Double> getCritChance() {
        return new RarityValue<>(0.02, 0.03, 0.04, 0.07, 0.10, 0.12);
    }

    @Override
    public RarityValue<Double> getCritDamage() {
        return new RarityValue<>(0.02, 0.03, 0.04, 0.07, 0.10, 0.12);
    }

    @Override
    public RarityValue<Double> getIntelligence() {
        return new RarityValue<>(2.0, 3.0, 4.0, 7.0, 10.0, 12.0);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.WEAPON);
    }
}
