package me.adarsh.godspunkycore.features.entity.end;

import me.adarsh.godspunkycore.features.entity.EntityStatistics;
import org.bukkit.material.MaterialData;

public interface EndermanStatistics extends EntityStatistics {
    default MaterialData getCarriedMaterial() {
        return null;
    }
}