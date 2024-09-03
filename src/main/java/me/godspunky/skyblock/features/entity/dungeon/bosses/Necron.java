package me.godspunky.skyblock.features.entity.dungeon.bosses;

import me.godspunky.skyblock.features.entity.EntityFunction;
import me.godspunky.skyblock.features.entity.EntityStatistics;

public class Necron implements EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "&e&l{&cNecron&l&e}";
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
