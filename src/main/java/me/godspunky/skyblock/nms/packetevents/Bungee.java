package me.godspunky.skyblock.nms.packetevents;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.util.ArrayList;
import java.util.List;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.util.SLog;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Bungee {
    private String channel;

    private List<String> servers = new ArrayList<>();

    public Bungee(String channel) {
        this.channel = channel;
    }

    public static Bungee getNewBungee() {
        return new Bungee("BungeeCord");
    }

    public void sendData(Player p, String subchannel, String args) {
        Player sender = null;
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF(subchannel);
        if (args != null)
            out.writeUTF(args);
        if (p == null) {
            sender = (Player)Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
        } else {
            sender = p;
        }
        if (sender != null) {
            sender.sendPluginMessage((Plugin) Skyblock.getPlugin(), this.channel, out.toByteArray());
        } else {
            SLog.warn("Player object mustn't be null!");
        }
    }
}


/* Location:              C:\Users\Administrator\Downloads\legacy-2022-05-build143.jar!\vn\giakhanhvn\skysim\nms\nmsutil\apihelper\SkySimBungee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */