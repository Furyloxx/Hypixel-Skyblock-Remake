package me.adarsh.godspunkycore.features.item.weapon.Abilites.bonzo;


import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.util.SkullMaker;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class BonzoStaffProjectile {

    public BonzoStaffProjectile(Player p) {
        p.getWorld().playSound(p.getLocation(), Sound.GHAST_SCREAM, 1.0f, 10.0f);
        final Location loc = p.getLocation();
        loc.setY(loc.getY() + 1.2);
        Float yaw = (float)(Math.random() * 15.0);
        yaw = (float)(yaw - 7.5);
        //loc.setYaw(loc.getYaw() + yaw);
        final Vector vecTo = loc.getDirection().normalize().multiply(0.8);
        final Entity ent = p.getWorld().spawn(loc, (Class)ArmorStand.class);
        final ArmorStand stand = (ArmorStand)ent;
        stand.setVisible(false);
        stand.teleport(stand.getLocation().clone().add(vecTo));
        stand.setArms(true);
        stand.setGravity(false);
        stand.setMarker(true);
        final int i = Bukkit.getScheduler().scheduleSyncRepeatingTask(Skyblock.getPlugin(), (Runnable)new BonzoStaffRun(stand, p, vecTo), 0L, 1L);
        new BukkitRunnable() {
            int type;

            public void run() {
                this.type = (int)(Math.random() * 5.0);
                ItemStack item = null;
                if (this.type == 0) {
                    item = SkullMaker.CreateFromTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTI2ZWM3Y2QzYjZhZTI0OTk5NzEzN2MxYjk0ODY3YzY2ZTk3NDk5ZGEwNzFiZjUwYWRmZDM3MDM0MTMyZmEwMyJ9fX0=");
                    final ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("THROW_BALOON");
                    item.setItemMeta(meta);
                }
                if (this.type == 1) {
                    item = SkullMaker.CreateFromTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTJkZDExZGEwNDI1MmY3NmI2OTM0YmMyNjYxMmY1NGYyNjRmMzBlZWQ3NGRmODk5NDEyMDllMTkxYmViYzBhMiJ9fX0=");
                    final ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("THROW_BALOON");
                    item.setItemMeta(meta);
                }
                if (this.type == 2) {
                    item = SkullMaker.CreateFromTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGY4NTUyMmVlODE1ZDExMDU4N2ZmZmM3NDExM2Y0MTlkOTI5NTk4ZTI0NjNiOGNlOWQzOWNhYTlmYjZmZjVhYiJ9fX0=");
                    final ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("THROW_BALOON");
                    item.setItemMeta(meta);
                }
                if (this.type == 3) {
                    item = SkullMaker.CreateFromTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzYzODdmYzI0Njg5M2Q5MmE2ZGQ5ZWExYjUyZGNkNTgxZTk5MWVlZWUyZTI2M2IyN2ZmZjFiY2YxYjE1NGViNyJ9fX0=");
                    final ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("THROW_BALOON");
                    item.setItemMeta(meta);
                }
                if (this.type == 4) {
                    item = SkullMaker.CreateFromTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjg2OGU2YTVjNGE0NDVkNjBhMzA1MGI1YmVjMWQzN2FmMWIyNTk0Mzc0NWQyZDQ3OTgwMGM4NDM2NDg4MDY1YSJ9fX0=");
                    final ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("THROW_BALOON");
                    item.setItemMeta(meta);
                }
                if (this.type == 5) {
                    item = SkullMaker.CreateFromTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2EyZGYzMTViNDM1ODNiMTg5NjIzMWI3N2JhZTFhNTA3ZGJkN2U0M2FkODZjMWNmYmUzYjJiOGVmMzQzMGU5ZSJ9fX0=");
                    final ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("THROW_BALOON");
                    item.setItemMeta(meta);
                }
                stand.setHelmet(item);
            }
        }.runTaskLater(Skyblock.getPlugin(), 3L);
        new BukkitRunnable() {
            public void run() {
               BonzoStaffRun.cancel(i, stand);
            }
        }.runTaskLater(Skyblock.getPlugin(), 30L);
    }
}
