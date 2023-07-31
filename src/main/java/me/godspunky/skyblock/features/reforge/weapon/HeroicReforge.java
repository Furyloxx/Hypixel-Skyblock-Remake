package me.godspunky.skyblock.features.reforge.weapon;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.RarityValue;
import me.godspunky.skyblock.features.reforge.Reforge;

import java.util.Collections;
import java.util.List;

public class HeroicReforge implements Reforge {
    @Override
    public String getName() {
        return "Heroic";
    }

    @Override
    public RarityValue<Double> getStrength() {
        return new RarityValue<>(15.0, 20.0, 25.0, 32.0, 40.0, 50.0);
    }

    @Override
    public RarityValue<Double> getIntelligence() {
        return new RarityValue<>(40.0, 50.0, 65.0, 80.0, 100.0, 125.0);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.WEAPON);
    }
}