package me.adarsh.godspunkycore.entity.wolf;

import me.adarsh.godspunkycore.entity.Ageable;
import me.adarsh.godspunkycore.entity.EntityStatistics;

public interface WolfStatistics extends EntityStatistics, Ageable
{
    default boolean isAngry()
    {
        return false;
    }
}