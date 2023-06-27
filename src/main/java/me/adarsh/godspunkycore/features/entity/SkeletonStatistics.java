package me.adarsh.godspunkycore.features.entity;

public interface SkeletonStatistics extends EntityStatistics {
    default boolean isWither() {
        return false;
    }
}