package me.adarsh.godspunkycore.entity;

public interface SkeletonStatistics extends EntityStatistics
{
    default boolean isWither()
    {
        return false;
    }
}