package me.adarsh.godspunkycore.features.entity.end;

import me.adarsh.godspunkycore.features.entity.EntityFunction;

public class Enderman implements EndermanStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Enderman";
    }

    @Override
    public double getEntityMaxHealth() {
        return 6000.0;
    }

    @Override
    public double getDamageDealt() {
        return 600.0;
    }

    @Override
    public double getXPDropped() {
        return 32.0;
    }
}