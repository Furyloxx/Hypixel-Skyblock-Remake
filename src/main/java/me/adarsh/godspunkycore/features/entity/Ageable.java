package me.adarsh.godspunkycore.features.entity;

public interface Ageable {
    default boolean isBaby() {
        return false;
    }
}