package me.godspunky.skyblock.listener;

import me.godspunky.skyblock.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerPingListener extends PListener {
    @EventHandler
    public void onServerPing(ServerListPingEvent e) {
        e.setMotd(ChatColor.GREEN + "              Godspunky SKYBLOCK " + ChatColor.RED + "[1.8-1.18]\n                     " + SUtil.getRandomVisibleColor() + ChatColor.BOLD + "SKYBLOCK STUFF");
        e.setMaxPlayers(200);
    }
}
