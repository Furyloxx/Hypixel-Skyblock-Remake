package me.adarsh.godspunkycore.entity.end;

import me.adarsh.godspunkycore.entity.EntityStatistics;
import org.bukkit.material.MaterialData;

public interface EndermanStatistics extends EntityStatistics {
    default MaterialData getCarriedMaterial() {
        return null;
    }
}