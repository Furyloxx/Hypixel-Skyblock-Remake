package me.adarsh.godspunkycore.features.entity.dungeon;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.EntityStatistics;

public class Thorn implements EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "✪ Thorn ✪";
    }

    @Override
    public double getEntityMaxHealth() {
        return 4000000.0;
    }

    @Override
    public double getDamageDealt() {
        return 8840.0;
    }


    @Override
    public double getXPDropped() {
        return 200.0;
    }
}


