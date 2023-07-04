package me.adarsh.godspunkycore.features.entity.dungeon.bosses;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.EntityStatistics;

public class Golder implements EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "✪ Goldor ✪";
    }

    @Override
    public double getEntityMaxHealth() {
        return 750000000.0;
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
