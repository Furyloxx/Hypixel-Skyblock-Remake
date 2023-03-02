package me.adarsh.godspunkycore.sequence;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public interface Sequence {
    void play(Location location);

    void play(Entity entity);
}