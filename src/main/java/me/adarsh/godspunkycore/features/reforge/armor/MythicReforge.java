package me.adarsh.godspunkycore.features.reforge.armor;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.RarityValue;
import me.adarsh.godspunkycore.features.reforge.Reforge;

import java.util.Collections;
import java.util.List;

public class MythicReforge implements Reforge {
    @Override
    public String getName() {
        return "Mythic";
    }

    @Override
    public RarityValue<Double> getStrength() {
        return new RarityValue<>(2.0, 4.0, 6.0, 8.0, 10.0, 12.0);
    }

    @Override
    public RarityValue<Double> getCritChance() {
        return new RarityValue<>(0.01, 0.02, 0.03, 0.04, 0.05, 0.06);
    }

    @Override
    public RarityValue<Double> getIntelligence() {
        return new RarityValue<>(20.0, 25.0, 30.0, 40.0, 50.0, 60.0);
    }

    @Override
    public RarityValue<Double> getDefence() {
        return new RarityValue<>(2.0, 4.0, 6.0, 8.0, 10.0, 12.0);
    }

    @Override
    public RarityValue<Double> getHealth() {
        return new RarityValue<>(2.0, 4.0, 6.0, 8.0, 10.0, 12.0);
    }

    @Override
    public RarityValue<Double> getSpeed() {
        return new RarityValue<>(0.02, 0.02, 0.02, 0.02, 0.02, 0.02);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.ARMOR);
    }
}
