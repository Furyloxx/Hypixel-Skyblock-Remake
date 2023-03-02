package me.adarsh.godspunkycore.reforge.weapon;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.RarityValue;
import me.adarsh.godspunkycore.reforge.Reforge;

import java.util.Collections;
import java.util.List;

public class SharpReforge implements Reforge {
    @Override
    public String getName() {
        return "Sharp";
    }

    @Override
    public RarityValue<Double> getCritChance() {
        return new RarityValue<>(0.10, 0.12, 0.14, 0.17, 0.20, 0.25);
    }

    @Override
    public RarityValue<Double> getCritDamage() {
        return new RarityValue<>(0.20, 0.30, 0.40, 0.55, 0.75, 0.90);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.WEAPON);
    }
}
