package me.godspunky.skyblock.features.entity;

public interface ZombieStatistics extends EntityStatistics, Ageable {
    default boolean isVillager() {
        return false;
    }
    default double speed(){
        return 0;
    }
}