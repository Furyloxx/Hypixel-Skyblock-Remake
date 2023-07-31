package me.adarsh.godspunkycore.features.entity.dungeon;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.EntityStatistics;
import me.adarsh.godspunkycore.features.entity.ZombieStatistics;

public class Undead implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Undead";
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
        return 50000;
    }

    @Override
    public double getDamageDealt() {
        return 1040.0;
    }

    @Override
    public double getXPDropped() {
        return 30.0;
    }

    @Override
    public double getMovementSpeed() {
        return 0.1;
    }

}
