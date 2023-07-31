package me.godspunky.skyblock.features.entity.nether;

import me.godspunky.skyblock.features.entity.EntityFunction;
import me.godspunky.skyblock.features.entity.SlimeStatistics;

public class MediumMagmaCube implements SlimeStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Magma Cube";
    }

    @Override
    public double getEntityMaxHealth() {
        return 250.0;
    }

    @Override
    public double getDamageDealt() {
        return 120.0;
    }

    @Override
    public double getXPDropped() {
        return 4.0;
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public boolean split() {
        return false;
    }
}