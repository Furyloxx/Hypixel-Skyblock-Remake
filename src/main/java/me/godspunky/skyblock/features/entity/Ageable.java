package me.godspunky.skyblock.features.entity;

public interface Ageable {
    default boolean isBaby() {
        return false;
    }
}