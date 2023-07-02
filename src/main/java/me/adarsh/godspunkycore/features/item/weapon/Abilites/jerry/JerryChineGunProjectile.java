package me.adarsh.godspunkycore.features.item.weapon.Abilites.jerry;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.item.weapon.Abilites.bonzo.BonzoStaffRun;
import me.adarsh.godspunkycore.util.SkullMaker;
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

public class JerryChineGunProjectile {

    public JerryChineGunProjectile(Player p) {
        p.getWorld().playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0f, 10.0f);
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
        final int i = Bukkit.getScheduler().scheduleSyncRepeatingTask(Skyblock.getPlugin(), (Runnable)new JerryChineGunRun(stand, p, vecTo), 0L, 1L);
        new BukkitRunnable() {
            int type;

            public void run() {
                this.type = (int)(Math.random() * 5.0);
                ItemStack item = null;
                if (this.type == 0) {
                    item = SkullMaker.CreateFromTexture("ce1fac3d96346e622e890f76ec015a709b673422257b1442061a3aa325982411=");
                    final ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("Head");
                    item.setItemMeta(meta);
                }
                if (this.type == 1) {
                    item = SkullMaker.CreateFromTexture("ce1fac3d96346e622e890f76ec015a709b673422257b1442061a3aa325982411=");
                    final ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("Head");
                    item.setItemMeta(meta);
                }
                if (this.type == 2) {
                    item = SkullMaker.CreateFromTexture("ce1fac3d96346e622e890f76ec015a709b673422257b1442061a3aa325982411=");
                    final ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("Head");
                    item.setItemMeta(meta);
                }
                if (this.type == 3) {
                    item = SkullMaker.CreateFromTexture("ce1fac3d96346e622e890f76ec015a709b673422257b1442061a3aa325982411=");
                    final ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("Head");
                    item.setItemMeta(meta);
                }
                if (this.type == 4) {
                    item = SkullMaker.CreateFromTexture("ce1fac3d96346e622e890f76ec015a709b673422257b1442061a3aa325982411=");
                    final ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("Head");
                    item.setItemMeta(meta);
                }
                if (this.type == 5) {
                    item = SkullMaker.CreateFromTexture("ce1fac3d96346e622e890f76ec015a709b673422257b1442061a3aa325982411=");
                    final ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("Head");
                    item.setItemMeta(meta);
                }
                stand.setHelmet(item);
            }
        }.runTaskLater(Skyblock.getPlugin(), 3L);
        new BukkitRunnable() {
            public void run() {
                JerryChineGunRun.cancel(i, stand);

            }
        }.runTaskLater(Skyblock.getPlugin(), 30L);
    }
}
