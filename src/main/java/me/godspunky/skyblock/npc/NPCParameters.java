package me.godspunky.skyblock.npc;

import org.bukkit.entity.Player;

public interface NPCParameters {
    String name();

    String[] holograms();
    String texture();
    String signature();
    String world();
    double x();
    double y();
    double z();
    float yaw();
    float pitch();

    boolean looking();
    void onInteract(Player player , SkyblockNPC npc);
}
