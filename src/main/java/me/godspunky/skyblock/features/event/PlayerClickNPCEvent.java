package me.godspunky.skyblock.features.event;

import lombok.Getter;
import me.godspunky.skyblock.npc.SkyblockNPC;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerClickNPCEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private boolean isCanceled;

    @Getter
    private final Player player;
    private final SkyblockNPC npc;

    public PlayerClickNPCEvent(Player player, SkyblockNPC npc) {
        this.player = player;
        this.npc = npc;
        this.isCanceled = false;
    }

    public SkyblockNPC getNPC() {
        return npc;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return isCanceled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCanceled = b;

    }
}