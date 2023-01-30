package me.adarsh.godspunkycore.entity;

public interface Ageable
{
    default boolean isBaby()
    {
        return false;
    }
}