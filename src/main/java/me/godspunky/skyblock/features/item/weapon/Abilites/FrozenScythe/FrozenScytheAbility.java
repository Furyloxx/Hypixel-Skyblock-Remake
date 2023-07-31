package me.godspunky.skyblock.features.item.weapon.Abilites.FrozenScythe;

import me.godspunky.skyblock.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

public class FrozenScytheAbility
{
    public static void Throw(Player p) {
            p.getWorld().playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 10.0f);
            Location loc = p.getLocation();
            loc.setY(loc.getY() + 1.0);
            final Vector vecTo1 = loc.getDirection().normalize().multiply(0.3);
            final Vector vecTo2 = loc.getDirection().normalize().multiply(1);
            final Vector back = loc.getDirection().normalize().multiply(-1);
            final ItemStack item = new ItemStack(Material.ICE);
            final ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("ice");
            item.setItemMeta(meta);
            loc = loc.add(vecTo1);
            final Entity ent1 = p.getWorld().spawn(loc, (Class)ArmorStand.class);
            final ArmorStand stand1 = (ArmorStand)ent1;
            stand1.setVisible(false);
            stand1.setArms(true);
            stand1.setGravity(false);
            stand1.setItemInHand(item);
            stand1.setSmall(true);
            item.setType(Material.PACKED_ICE);
            loc = loc.add(vecTo1);
            final Entity ent2 = p.getWorld().spawn(loc, (Class)ArmorStand.class);
            final ArmorStand stand2 = (ArmorStand)ent2;
            stand2.setVisible(false);
            stand2.setArms(true);
            stand2.setGravity(false);
            stand2.setItemInHand(item);
            stand2.setSmall(true);
            item.setType(Material.ICE);
            loc = loc.add(vecTo1);
            final Entity ent3 = p.getWorld().spawn(loc, (Class)ArmorStand.class);
            final ArmorStand stand3 = (ArmorStand)ent3;
            stand3.setVisible(false);
            stand3.setArms(true);
            stand3.setGravity(false);
            stand3.setItemInHand(item);
            stand3.setSmall(true);
            item.setType(Material.PACKED_ICE);
            loc = loc.add(vecTo1);
            final Entity ent4 = p.getWorld().spawn(loc, (Class)ArmorStand.class);
            final ArmorStand stand4 = (ArmorStand)ent4;
            stand4.setVisible(false);
            stand4.setArms(true);
            stand4.setGravity(false);
            stand4.setItemInHand(item);
            stand4.setSmall(true);
            item.setType(Material.ICE);
            loc = loc.add(vecTo1);
            final Entity ent5 = p.getWorld().spawn(loc, (Class)ArmorStand.class);
            final ArmorStand stand5 = (ArmorStand)ent5;
            stand5.setVisible(false);
            stand5.setArms(true);
            stand5.setGravity(false);
            stand5.setItemInHand(item);
            stand5.setSmall(true);
            stand2.teleport(stand2.getLocation().add(vecTo2));
            stand3.teleport(stand3.getLocation().add(vecTo2.clone().multiply(2)));
            stand4.teleport(stand4.getLocation().add(vecTo2.clone().multiply(3)));
            stand5.teleport(stand5.getLocation().add(vecTo2.clone().multiply(4)));
            stand1.setRightArmPose(new EulerAngle(0.0, 0.0, 12.0));
            stand2.setRightArmPose(new EulerAngle(0.0, 0.0, 12.0));
            stand3.setRightArmPose(new EulerAngle(0.0, 0.0, 12.0));
            stand4.setRightArmPose(new EulerAngle(0.0, 0.0, 12.0));
            stand5.setRightArmPose(new EulerAngle(0.0, 0.0, 12.0));
            stand1.setMarker(true);
            stand2.setMarker(true);
            stand3.setMarker(true);
            stand4.setMarker(true);
            stand5.setMarker(true);

            new BukkitRunnable() {
                public void run() {
                    FrozenScytheAbility.throwIce(stand1, stand2, stand3, stand4, stand5, p, vecTo2, back);
                }
            }.runTaskLater(Skyblock.getPlugin(), 7L);
        }

    
    public static void throwIce(final ArmorStand stand1, final ArmorStand stand2, final ArmorStand stand3, final ArmorStand stand4, final ArmorStand stand5, final Player p, final Vector vecTo, final Vector back) {
        final int i = Bukkit.getScheduler().scheduleSyncRepeatingTask(Skyblock.getPlugin(), (Runnable)new FrozenScytheRun(stand1, stand2, stand3, stand4, stand5, p, vecTo, back), 0L, 1L);
        new BukkitRunnable() {
            public void run() {
                Bukkit.getScheduler().cancelTask(i);
                stand1.remove();
                stand2.remove();
                stand3.remove();
                stand4.remove();
                stand5.remove();
            }
        }.runTaskLater(Skyblock.getPlugin(), 80L);
    }
}
