package me.godspunky.skyblock.features.gift;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
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
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.Random;

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
            e.setCancelled(true);
            return;
        }

        // CLICK LISTENER
        if (rightClickedEntity.getType().equals(EntityType.ARMOR_STAND) && rightClickedEntity.getCustomName().contains("White Gift")) {

            ArmorStand gift = (ArmorStand) e.getRightClicked();
            if (gift.hasMetadata(rightclickedplayer.getName().toString()) && gift.hasMetadata(player.getName().toString())) {

                SUtil.delay(() -> player.playSound(loc, Sound.NOTE_PLING, 1.0f, 1.0f), 0);
                SUtil.delay(() -> player.playSound(loc, Sound.NOTE_PLING, 1.0f, 1.0f), 10);
                SUtil.delay(() -> player.playSound(loc, Sound.NOTE_PLING, 1.0f, 1.0f), 20);
                SUtil.delay(() -> player.playSound(loc, Sound.NOTE_PLING, 1.0f, 1.0f), 30);
                SUtil.delay(() -> player.playSound(loc, Sound.NOTE_PLING, 1.0f, 1.0f), 40);

                // Rewards By Chance
                // Use Random Function
            }

            // WHITE GIFT
            if (rightClickedEntity.getType().equals(EntityType.PLAYER)) {

                if (player.getInventory().getItemInHand().getType() == null) {
                    e.setCancelled(true);
                    return;
                }
                if (player.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("White Gift")) {

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

                    stand1.setCustomName(ChatColor.YELLOW + "From: " + player.getDisplayName());
                    stand2.setCustomName(ChatColor.YELLOW + "To: " + rightclickedplayer.getDisplayName());
                    stand.setCustomName("White Gift");
                    stand.setMetadata(rightclickedplayer.getName().toString(), new FixedMetadataValue(Skyblock.getPlugin(), "name"));
                    stand.setMetadata(player.getName().toString(), new FixedMetadataValue(Skyblock.getPlugin(), "playername"));

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
                        SItem sItem = SItem.of(SMaterial.WHITE_GIFT);
                        SUtil.delay(() -> player.getInventory().addItem(SItem.of(sItem.getType(), sItem.getVariant()).getStack()), 100);
                    }
                }
            }
        }
    }
}
