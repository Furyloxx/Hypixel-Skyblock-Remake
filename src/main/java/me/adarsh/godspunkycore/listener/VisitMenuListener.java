package me.adarsh.godspunkycore.listener;

import me.adarsh.godspunkycore.island.IslandManager;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class VisitMenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) throws Exception {
        if (event.getClickedInventory() == null || event.getCurrentItem() == null || event.getCurrentItem().getType().equals(Material.AIR)) return;

        if (!event.getClickedInventory().getTitle().startsWith("Visit ")) return;

        event.setCancelled(true);

        if (event.getCurrentItem().getType().equals(Material.BARRIER)) event.getWhoClicked().closeInventory();
        else if (event.getCurrentItem().getType().equals(Material.SKULL_ITEM)) {
            event.getWhoClicked().closeInventory();

            String name = ChatColor.stripColor(event.getView().getTitle().replace("Visit ", ""));

            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(name);

            event.getWhoClicked().teleport(new Location(IslandManager.getIsland(offlinePlayer.getUniqueId()), 0, 100, 0));
        }
    }
}
