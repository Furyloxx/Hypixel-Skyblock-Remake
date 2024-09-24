package me.godspunky.skyblock.npc;

import org.bukkit.entity.Player;

public interface NPCParameters {
    String getName();
    String[] getHolograms();
    String getTexture();
    String getSignature();
    String getWorld();
    double getX();
    double getY();
    double getZ();
    float getYaw();
    float getPitch();
    boolean isLooking();
    void onInteract(Player player, SkyblockNPC npc);
}

