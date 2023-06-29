package me.adarsh.godspunkycore.features.ranks;

import me.adarsh.godspunkycore.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener {
    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e) {
        Bukkit.getScheduler().runTaskAsynchronously(Skyblock.getPlugin(), () -> new GodspunkyPlayer(e.getPlayer()));
    }
    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent e) {
        Bukkit.getScheduler().runTaskAsynchronously(Skyblock.getPlugin(), () -> GodspunkyPlayer.unloadPlayer(e.getPlayer()));
    }
}
