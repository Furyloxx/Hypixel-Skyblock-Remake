package me.adarsh.godspunkycore.listener;

import me.adarsh.godspunkycore.GodSpunkySkyblockMain;
import org.bukkit.event.Listener;

public class PListener implements Listener {
    private static int amount = 0;

    protected GodSpunkySkyblockMain plugin;

    protected PListener() {
        this.plugin = GodSpunkySkyblockMain.getPlugin();
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
        amount++;
    }

    public static int getAmount() {
        return amount;
    }
}