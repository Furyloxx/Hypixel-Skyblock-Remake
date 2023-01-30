package me.adarsh.godspunkycore.entity;

public interface ZombieStatistics extends EntityStatistics, Ageable
{
    default boolean isVillager()
    {
        return false;
    }
}