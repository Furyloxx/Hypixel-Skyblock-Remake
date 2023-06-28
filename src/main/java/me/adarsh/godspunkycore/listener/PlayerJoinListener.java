package me.adarsh.godspunkycore.listener;

import me.adarsh.godspunkycore.features.islands.IslandManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void createIsland(PlayerJoinEvent event) throws IOException {
        event.setJoinMessage(null);
        IslandManager.createIsland(event.getPlayer());
    }

}
