package me.godspunky.skyblock.features.entity.end;

import me.godspunky.skyblock.features.entity.EntityStatistics;
import org.bukkit.material.MaterialData;

public interface EndermanStatistics extends EntityStatistics {
    default MaterialData getCarriedMaterial() {
        return null;
    }
}