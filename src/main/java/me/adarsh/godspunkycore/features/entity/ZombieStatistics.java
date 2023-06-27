package me.adarsh.godspunkycore.features.entity;

public interface ZombieStatistics extends EntityStatistics, Ageable {
    default boolean isVillager() {
        return false;
    }
}