package me.adarsh.godspunkycore.reforge.weapon;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.RarityValue;
import me.adarsh.godspunkycore.reforge.Reforge;

import java.util.Collections;
import java.util.List;

public class EpicReforge implements Reforge {
    @Override
    public String getName() {
        return "Epic";
    }

    @Override
    public RarityValue<Double> getStrength() {
        return new RarityValue<>(15.0, 20.0,25.0,32.0,40.0,50.0);
    }

    @Override
    public RarityValue<Double> getCritDamage() {
        return new RarityValue<>(0.10,0.15,0.20,0.27,0.35,0.45);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.WEAPON);
    }
}
