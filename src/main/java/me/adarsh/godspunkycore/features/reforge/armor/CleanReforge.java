package me.adarsh.godspunkycore.features.reforge.armor;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.RarityValue;
import me.adarsh.godspunkycore.features.reforge.Reforge;

import java.util.Collections;
import java.util.List;

public class CleanReforge implements Reforge {
    @Override
    public String getName() {
        return "Clean";
    }

    @Override
    public RarityValue<Double> getCritChance() {
        return new RarityValue<>(0.02, 0.04, 0.06, 0.08, 0.10, 0.12);
    }

    @Override
    public RarityValue<Double> getDefence() {
        return new RarityValue<>(5.0, 7.0, 10.0, 15.0, 20.0, 25.0);
    }

    @Override
    public RarityValue<Double> getHealth() {
        return new RarityValue<>(5.0, 7.0, 10.0, 15.0, 20.0, 25.0);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.ARMOR);
    }
}
