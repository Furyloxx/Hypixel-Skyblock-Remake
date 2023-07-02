package me.adarsh.godspunkycore.features.entity.dungeon;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.EntityStatistics;

public class Necron implements EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "✪ Necron ✪";
    }

    @Override
    public double getEntityMaxHealth() {
        return 1000000000.0;
    }

    @Override
    public double getDamageDealt() {
        return 54540.0;
    }


    @Override
    public double getXPDropped() {
        return 300.0;
    }
}
