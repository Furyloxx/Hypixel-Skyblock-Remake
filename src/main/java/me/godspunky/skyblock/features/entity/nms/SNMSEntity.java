package me.godspunky.skyblock.features.entity.nms;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

public interface SNMSEntity {
    LivingEntity spawn(Location location);
}