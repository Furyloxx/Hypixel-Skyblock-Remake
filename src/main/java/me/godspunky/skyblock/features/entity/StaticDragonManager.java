package me.godspunky.skyblock.features.entity;

import me.godspunky.skyblock.Skyblock;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class StaticDragonManager {
    public static boolean ACTIVE = false;
    public static Map<UUID, List<Location>> EYES = new HashMap<>();
    public static SEntity DRAGON = null;

    public static void endFight() {
        if (DRAGON == null) return;
        ACTIVE = false;
        for (List<Location> locations : StaticDragonManager.EYES.values()) {
            for (Location location : locations) {
                Block b = location.getBlock();
                BlockState s = b.getState();
                s.setRawData((byte) 0);
                s.update();
                b.removeMetadata("placer", Skyblock.getPlugin());
            }
        }
        EYES.clear();
        DRAGON = null;
    }
}