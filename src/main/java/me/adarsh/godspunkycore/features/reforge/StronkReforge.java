package me.adarsh.godspunkycore.features.reforge;

import me.adarsh.godspunkycore.features.item.RarityValue;

public class StronkReforge implements Reforge
{
    @Override
    public String getName() {
        return "Stronky";
    }

    @Override
    public RarityValue<Double> getStrength() {
        return new RarityValue<Double>(30.0, 50.0, 60.0, 70.0, 80.0, 100.0);
    }

    @Override
    public RarityValue<Double> getCritChance() {
        return new RarityValue<Double>(0.1, 0.15, 0.2, 0.25, 0.3, 0.35);
    }

    @Override
    public RarityValue<Double> getFerocity() {
        return RarityValue.singleDouble(0.0);
    }

    @Override
    public RarityValue<Double> getAttackSpeed() {
        return RarityValue.singleDouble(8.0);
    }

    @Override
    public RarityValue<Double> getCritDamage() {
        return new RarityValue<Double>(0.1, 0.25, 0.3, 0.35, 0.4, 0.55);
    }

    @Override
    public RarityValue<Double> getIntelligence() {
        return RarityValue.singleDouble(500.0);
    }
}
