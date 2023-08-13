package me.godspunky.skyblock.nms.packetevents;

import org.bukkit.entity.Player;

public class WrappedPluginMessage {
    private String channelName;

    private Player player;

    private byte[] message;

    public String getChannelName() {
        return this.channelName;
    }

    public Player getPlayer() {
        return this.player;
    }

    public byte[] getMessage() {
        return this.message;
    }

    public WrappedPluginMessage(String cn, Player p, byte[] msg) {
        this.channelName = cn;
        this.player = p;
        this.message = msg;
    }
}


/* Location:              C:\Users\Administrator\Downloads\legacy-2022-05-build143.jar!\vn\giakhanhvn\skysim\nms\packetevents\WrappedPluginMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */