package me.godspunky.skyblock.features.item.weapon.Abilites.dreadlord;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.util.SkullMaker;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class DreadlordProjectile {
    public DreadlordProjectile(Player p) {
        p.getWorld().playSound(p.getLocation(), Sound.WITHER_SHOOT, 1.0f, 10.0f);
        final Location loc = p.getLocation();
        loc.setY(loc.getY() + 1.2);
        Float yaw = (float)(Math.random() * 15.0);
        yaw = (float)(yaw - 7.5);
        //loc.setYaw(loc.getYaw() + yaw);
        final Vector vecTo = loc.getDirection().normalize().multiply(0.8);
        final Entity ent = p.getWorld().spawn(loc, (Class) ArmorStand.class);
        final ArmorStand stand = (ArmorStand)ent;
        stand.setVisible(false);
        stand.teleport(stand.getLocation().clone().add(vecTo));
        stand.setArms(true);
        stand.setGravity(false);
        stand.setMarker(true);
        final int i = Bukkit.getScheduler().scheduleSyncRepeatingTask(Skyblock.getPlugin(), (Runnable)new DreadlordRun(stand, p, vecTo), 0L, 1L);

        ItemStack item = null;

        item = SkullMaker.CreateFromTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODg2ZGMwY2ZjYWVlY2ZlMWFiNjkxNDZlNGQ0ZjExOTA4MzcwNzZhNjdkZWMxMzVmYWJkYTYyNzFmMzc1ZDAxZiJ9fX0=");
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Head");
        item.setItemMeta(meta);
        stand.setHelmet(item);


        new BukkitRunnable() {
            public void run() {
                DreadlordRun.cancel(i, stand);
            }
        }.runTaskLater(Skyblock.getPlugin(), 30L);

    }
}