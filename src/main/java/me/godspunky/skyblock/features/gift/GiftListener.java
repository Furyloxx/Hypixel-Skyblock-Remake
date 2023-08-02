package me.godspunky.skyblock.features.gift;

import me.godspunky.skyblock.features.ranks.GodspunkyPlayer;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.SkullMaker;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiftListener implements Listener {
    @EventHandler
    public void OnRightClick(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        Player rightclickedplayer = (Player) e.getRightClicked();
        GodspunkyPlayer userplayer = GodspunkyPlayer.getUser(player);
        GodspunkyPlayer rightclickplayer = GodspunkyPlayer.getUser(rightclickedplayer);
        Location loc = player.getLocation().add(0, -1.5, 0);
        Location loc1 = player.getLocation().add(0, -0.5, 0);
        Location loc2 = player.getLocation().add(0, -1, 0);
        Entity rightClickedEntity = e.getRightClicked();

        if (!(rightClickedEntity instanceof Player)) {
            return;
        }

        // WHITE GIFT
        ItemStack itemInHand = player.getInventory().getItemInHand();
        if (itemInHand == null || itemInHand.getType() == null) {
            return;
        }
        if (rightclickedplayer.getType().equals(EntityType.PLAYER)) {

            if (player.getInventory().getItemInHand().getType() == null) {
                return;
            }
            if (player.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("White Gift")) {
                if (player.getWorld() == null) {
                    e.setCancelled(true);
                    player.sendMessage("Null World");
                    return;
                }

                Entity ent = player.getWorld().spawn(loc, (Class) ArmorStand.class);
                ArmorStand stand = (ArmorStand) ent;
                Entity ent1 = player.getWorld().spawn(loc1, (Class) ArmorStand.class);
                ArmorStand stand1 = (ArmorStand) ent1;
                Entity ent2 = player.getWorld().spawn(loc2, (Class) ArmorStand.class);
                ArmorStand stand2 = (ArmorStand) ent2;

                if (player.getInventory().getItemInHand().getAmount() > 1) {
                    player.getInventory().getItemInHand().setAmount(player.getInventory().getItemInHand().getAmount() - 1);
                } else {
                    player.getInventory().setItemInHand(null);
                }

                stand1.setCustomName(ChatColor.YELLOW + "From: " + ChatColor.translateAlternateColorCodes('&', userplayer.rank.getFormattedRank().toString()) + player.getDisplayName());
                stand2.setCustomName(ChatColor.YELLOW + "To: " + ChatColor.translateAlternateColorCodes('&', rightclickplayer.rank.getFormattedRank().toString()) + rightclickedplayer.getDisplayName());
                stand.setCustomName("White Gift");

                stand.setCustomNameVisible(false);
                stand1.setCustomNameVisible(true);
                stand2.setCustomNameVisible(true);
                stand.setVisible(false);
                stand1.setVisible(false);
                stand2.setVisible(false);
                stand.setGravity(false);
                stand1.setGravity(false);
                stand2.setGravity(false);

                player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1.0f, 1.0f);
                rightclickedplayer.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1.0f, 1.0f);

                ItemStack item = null;
                item = SkullMaker.CreateFromTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTVjNjk0NDU5MzgyMGQxM2Q3ZDQ3ZGIyYWJjZmNiZjY4M2JiNzRhMDdlMWE5ODJkYjlmMzJlMGE4YjVkYzQ2NiJ9fX0=");
                final ItemMeta meta = item.getItemMeta();
                meta.setDisplayName("Head");
                item.setItemMeta(meta);
                stand.setHelmet(item);

                if (!ent.isDead()) {
                    SUtil.delay(() -> ent.remove(), 100);
                    SUtil.delay(() -> ent1.remove(), 100);
                    SUtil.delay(() -> ent2.remove(), 100);

                    // RETURN GIFT
                    player.getInventory().addItem();
                }

            } else {
                player.sendMessage("not an gift");
            }
        }
    }
}
