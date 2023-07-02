package me.adarsh.godspunkycore.features.entity.dungeon;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.EntityStatistics;
import me.adarsh.godspunkycore.features.entity.ZombieStatistics;

public class Maxor implements  EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "✪ Sadan ✪";
    }

    @Override
    public double getEntityMaxHealth() {
        return 100000000.0;
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




