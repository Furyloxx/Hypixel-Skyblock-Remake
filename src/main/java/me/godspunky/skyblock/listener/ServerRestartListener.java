package me.godspunky.skyblock.listener;

import me.godspunky.skyblock.util.Sputnik;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class ServerRestartListener implements Listener {

    public static final int RESTART_INTERVAL_SECONDS = 7200; // 2 hours (2 hours * 60 minutes * 60 seconds)
    private final int RESTART_WARNING_SECONDS = 60; // 60 seconds warning before restart
    private static BukkitTask restartTask; // Store the scheduled task as static

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        scheduleServerRestart();
    }

    public void scheduleServerRestart() {
        restartTask = new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(Sputnik.trans("&c[Important] &eThe server will restart soon for regular maintenance."));
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 0.0F);
                }

                // Perform any other actions or announcements before the restart (if needed)

                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "restart");
            }
        }.runTaskLater(Bukkit.getPluginManager().getPlugin("YourPluginName"), (RESTART_INTERVAL_SECONDS - RESTART_WARNING_SECONDS) * 20L); // Convert seconds to ticks
    }

    public static BukkitTask getRestartTask() {
        return restartTask;
    }

    public void cancelServerRestart() {
        if (restartTask != null) {
            restartTask.cancel();
        }
    }
}
