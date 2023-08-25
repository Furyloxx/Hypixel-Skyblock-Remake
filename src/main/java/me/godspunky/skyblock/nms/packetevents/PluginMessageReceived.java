package me.godspunky.skyblock.nms.packetevents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PluginMessageReceived extends Event {
    private static final HandlerList handlers = new HandlerList();

    private WrappedPluginMessage a;

    public PluginMessageReceived(WrappedPluginMessage b) {
        this.a = b;
    }

    public WrappedPluginMessage getWrappedPluginMessage() {
        return this.a;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}


/* Location:              C:\Users\Administrator\Downloads\legacy-2022-05-build143.jar!\vn\giakhanhvn\skysim\nms\packetevents\PluginMessageReceived.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */