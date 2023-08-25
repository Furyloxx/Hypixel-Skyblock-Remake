package me.godspunky.skyblock.listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.nms.packetevents.PluginMessageReceived;
import me.godspunky.skyblock.nms.packetevents.WrappedPluginMessage;
import me.godspunky.skyblock.util.SLog;
import org.bukkit.event.EventHandler;

public class PacketListener extends PListener{


    @EventHandler
    public void onPluginChannel(PluginMessageReceived e) {
        WrappedPluginMessage w = e.getWrappedPluginMessage();
        String channel = w.getChannelName();
        byte[] message = w.getMessage();
        if (!channel.equals("BungeeCord"))
            return;
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        if (subchannel.equals("GetServer")) {
            String name = in.readUTF();
            if (Skyblock.getPlugin().getServerName().contains("Loading..."))
                SLog.info("Registered server instance name as " + name + " for this session!");
            Skyblock.getPlugin().setServerName(name);
        }
    }
}
