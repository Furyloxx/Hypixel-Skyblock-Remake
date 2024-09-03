package me.godspunky.skyblock.features.entity.dungeon.bosses;

import me.godspunky.skyblock.features.entity.EntityFunction;
import me.godspunky.skyblock.features.entity.EntityStatistics;

public class Strom implements EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "&e&l{&cMaxor&l&e}";
    }

    @Override
    public double getEntityMaxHealth() {
        return 400000000.0;
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
