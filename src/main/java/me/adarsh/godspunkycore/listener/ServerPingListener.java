package me.adarsh.godspunkycore.listener;

import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.util.CachedServerIcon;

public class ServerPingListener extends PListener {
    @EventHandler
    public void onServerPing(ServerListPingEvent e) {
        e.setMotd(ChatColor.GREEN + " GodSPUNKY SKYBLOCK" + ChatColor.RED + "[1.8-1.16]\n                     " + SUtil.getRandomVisibleColor() + ChatColor.BOLD + "SKYBLOCK STUFF");
        e.setMaxPlayers(200);
    }
}
