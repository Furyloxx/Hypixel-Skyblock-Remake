package me.adarsh.godspunkycore.features.entity.wolf;

import me.adarsh.godspunkycore.features.entity.Ageable;
import me.adarsh.godspunkycore.features.entity.EntityStatistics;

public interface WolfStatistics extends EntityStatistics, Ageable {
    default boolean isAngry() {
        return false;
    }
}