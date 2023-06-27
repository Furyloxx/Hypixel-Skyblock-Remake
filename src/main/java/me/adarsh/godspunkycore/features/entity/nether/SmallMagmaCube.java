package me.adarsh.godspunkycore.features.entity.nether;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.SlimeStatistics;

public class SmallMagmaCube implements SlimeStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Magma Cube";
    }

    @Override
    public double getEntityMaxHealth() {
        return 200.0;
    }

    @Override
    public double getDamageDealt() {
        return 70.0;
    }

    @Override
    public double getXPDropped() {
        return 4.0;
    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public boolean split() {
        return false;
    }
}