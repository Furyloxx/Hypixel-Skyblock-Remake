package me.adarsh.godspunkycore.listener;

import me.adarsh.godspunkycore.user.User;
import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class ProtectionListener implements Listener {


    @EventHandler
    public void WeatherEvent(WeatherChangeEvent e) {
        if (!e.getWorld().getName().contains("Islands")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void BucketEvent(PlayerBucketFillEvent e) {
        User user = User.getUser(e.getPlayer().getUniqueId());
        if (!user.isOnIsland()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void CraftEvent(CraftItemEvent e) {
        if (e.getRecipe().getResult().getType() == Material.FLINT_AND_STEEL || e.getRecipe().getResult().getType() == Material.FIREBALL) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void CommandEvent(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().toLowerCase().contains("bukkit") || e.getMessage().contains(".") || e.getMessage().equalsIgnoreCase("/pl") || e.getMessage().equalsIgnoreCase("/ver")) {
            e.getPlayer().sendMessage("§cYou don't have permission to execute this command.");
            e.setCancelled(true);
        }
        if (e.getMessage().startsWith("//") && !e.getPlayer().isOp()) {
            e.getPlayer().sendMessage("§cYou don't have permission to execute this command.");
            e.setCancelled(true);
        }
        if (e.getMessage().equalsIgnoreCase("/?") || e.getMessage().toLowerCase().startsWith("/about") || e.getMessage().toLowerCase().contains("/me")) {
            e.getPlayer().sendMessage("§cYou don't have permission to execute this command.");
            e.setCancelled(true);
        }
    }
    @EventHandler(priority = EventPriority.HIGH)
    public void PlaceEvent(BlockPlaceEvent e) {
        if (e.isCancelled()) {
            return;
        }
        if (e.getBlock().getType() == Material.SKULL || (e.getPlayer().getItemInHand().hasItemMeta() && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Enchanted"))) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void InteractEvent(PlayerInteractAtEntityEvent e) {
        User user = User.getUser(e.getPlayer().getUniqueId());
        if (e.getRightClicked() instanceof ItemFrame && !user.isOnIsland() && !e.getPlayer().isOp()) {
            e.setCancelled(true);
        }
    }

}







