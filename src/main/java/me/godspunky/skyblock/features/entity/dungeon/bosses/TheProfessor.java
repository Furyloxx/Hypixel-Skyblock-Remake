package me.godspunky.skyblock.features.entity.dungeon.bosses;

import me.godspunky.skyblock.features.entity.EntityFunction;
import me.godspunky.skyblock.features.entity.EntityStatistics;
import me.godspunky.skyblock.features.entity.ZombieStatistics;

public class TheProfessor implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "&cThe Professor";
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    public boolean isVillager() {
        return false;
    }

    @Override
    public double getEntityMaxHealth() {
        return 3000000.0;
    }

    @Override
    public double getDamageDealt() {
        return 6640.0;
    }


    @Override
    public double getXPDropped() {
        return 150.0;
    }

    @Override
    public double getMovementSpeed() {
        return 0.4;
    }
}

