package me.godspunky.skyblock.features.entity.dungeon.bosses;

import me.godspunky.skyblock.features.entity.EntityFunction;
import me.godspunky.skyblock.features.entity.EntityStatistics;

public class Golder implements EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "&e&l{&cGoldor&l&e}";
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
