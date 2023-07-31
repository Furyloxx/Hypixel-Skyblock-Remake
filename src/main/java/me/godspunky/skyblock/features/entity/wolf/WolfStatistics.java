package me.godspunky.skyblock.features.entity.wolf;

import me.godspunky.skyblock.features.entity.Ageable;
import me.godspunky.skyblock.features.entity.EntityStatistics;

public interface WolfStatistics extends EntityStatistics, Ageable {
    default boolean isAngry() {
        return false;
    }
}