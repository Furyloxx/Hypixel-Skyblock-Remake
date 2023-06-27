package me.adarsh.godspunkycore.features.entity.end;

import me.adarsh.godspunkycore.features.entity.EntityFunction;

public class StrongEnderman implements EndermanStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Enderman";
    }

    @Override
    public double getEntityMaxHealth() {
        return 9000.0;
    }

    @Override
    public double getDamageDealt() {
        return 700.0;
    }

    @Override
    public double getXPDropped() {
        return 36.0;
    }
}