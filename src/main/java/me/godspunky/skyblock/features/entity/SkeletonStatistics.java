package me.godspunky.skyblock.features.entity;

public interface SkeletonStatistics extends EntityStatistics {
    default boolean isWither() {
        return false;
    }
}