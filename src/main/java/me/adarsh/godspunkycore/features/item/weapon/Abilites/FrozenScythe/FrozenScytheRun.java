// 
// Decompiled by Procyon v0.5.36
// 

package me.adarsh.godspunkycore.features.item.weapon.Abilites.FrozenScythe;

import me.adarsh.godspunkycore.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class FrozenScytheRun implements Runnable
{
    private ArmorStand stand1;
    private ArmorStand stand2;
    private ArmorStand stand3;
    private ArmorStand stand4;
    private ArmorStand stand5;
    private Player p;
    Location loc;
    private Vector vecTo;
    private Vector back;
    private HashMap<Integer, Boolean> map;
    
    public FrozenScytheRun(final ArmorStand stand1, final ArmorStand stand2, final ArmorStand stand3, final ArmorStand stand4, final ArmorStand stand5, final Player player, final Vector vecTo, final Vector back) {
        this.stand1 = stand1;
        this.stand2 = stand2;
        this.stand3 = stand3;
        this.stand4 = stand4;
        this.stand5 = stand5;
        this.p = player;
        this.vecTo = vecTo;
        this.back = back;
        this.map = new HashMap<Integer, Boolean>();
    }
    
    @Override
    public void run() {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Skyblock.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                (FrozenScytheRun.this.loc = FrozenScytheRun.this.stand5.getLocation()).setY(FrozenScytheRun.this.loc.getY() + 0.6);
                FrozenScytheRun.this.loc = FrozenScytheRun.this.loc.add(FrozenScytheRun.this.back);
                FrozenScytheRun.this.loc = FrozenScytheRun.this.loc.add(FrozenScytheRun.this.back);
                FrozenScytheRun.this.loc = FrozenScytheRun.this.loc.add(FrozenScytheRun.this.back);
                final Vector back2 = FrozenScytheRun.this.loc.getDirection().normalize().multiply(-0.3);
                FrozenScytheRun.this.loc = FrozenScytheRun.this.loc.add(back2);
                for (final Entity e : FrozenScytheRun.this.stand1.getNearbyEntities(0.5, 0.5, 0.5)) {
                    LivingEntity e2 = null;
                    if (!(e instanceof Item) && !(e instanceof ExperienceOrb) && !(e instanceof ItemFrame) && !(e instanceof Villager) && !(e instanceof ArmorStand) && !e.isDead() && !(e instanceof Player)) {
                        e2 = (LivingEntity)e;
                        if (e2 == null || FrozenScytheRun.this.map.containsKey(e2.getEntityId())) {
                            continue;
                        }
                        FrozenScytheRun.this.map.put(e2.getEntityId(), true);
                    }
                }
                if (FrozenScytheRun.this.loc.getBlock().getType() != Material.AIR && FrozenScytheRun.this.loc.getBlock().getType() != Material.WATER && FrozenScytheRun.this.loc.getBlock().getType() != Material.STATIONARY_WATER) {
                    (FrozenScytheRun.this.loc = FrozenScytheRun.this.stand1.getLocation()).setY(FrozenScytheRun.this.loc.getY() + 0.5);
                    final Vector back3 = FrozenScytheRun.this.loc.getDirection().normalize().multiply(-0.1);
                    FrozenScytheRun.this.loc = FrozenScytheRun.this.loc.add(back3);
                    FrozenScytheRun.this.p.getWorld().spigot().playEffect(FrozenScytheRun.this.loc, Effect.FIREWORKS_SPARK, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0, 40);
                    new BukkitRunnable() {
                        public void run() {
                            FrozenScytheRun.this.stand1.remove();
                            FrozenScytheRun.this.stand2.remove();
                            FrozenScytheRun.this.stand3.remove();
                            FrozenScytheRun.this.stand4.remove();
                            FrozenScytheRun.this.stand5.remove();
                        }
                    }.runTaskLater(Skyblock.getPlugin(), 120L);
                    (FrozenScytheRun.this.loc = FrozenScytheRun.this.stand1.getEyeLocation()).setY(FrozenScytheRun.this.loc.getY() + 1.0);
                }
                else {
                    FrozenScytheRun.this.loc = FrozenScytheRun.this.stand1.getLocation();
                    FrozenScytheRun.this.loc = FrozenScytheRun.this.loc.add(FrozenScytheRun.this.back);
                    (FrozenScytheRun.this.loc = FrozenScytheRun.this.loc.add(FrozenScytheRun.this.back)).setY(FrozenScytheRun.this.loc.getY() + 0.5);
                    FrozenScytheRun.this.p.getWorld().spigot().playEffect(FrozenScytheRun.this.loc, Effect.FIREWORKS_SPARK, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0, 40);
                    FrozenScytheRun.this.stand1.teleport(FrozenScytheRun.this.stand1.getLocation().add(FrozenScytheRun.this.vecTo));
                    FrozenScytheRun.this.stand2.teleport(FrozenScytheRun.this.stand2.getLocation().add(FrozenScytheRun.this.vecTo));
                    FrozenScytheRun.this.stand3.teleport(FrozenScytheRun.this.stand3.getLocation().add(FrozenScytheRun.this.vecTo));
                    FrozenScytheRun.this.stand4.teleport(FrozenScytheRun.this.stand4.getLocation().add(FrozenScytheRun.this.vecTo));
                    FrozenScytheRun.this.stand5.teleport(FrozenScytheRun.this.stand5.getLocation().add(FrozenScytheRun.this.vecTo));
                }
            }
        });
    }
}
