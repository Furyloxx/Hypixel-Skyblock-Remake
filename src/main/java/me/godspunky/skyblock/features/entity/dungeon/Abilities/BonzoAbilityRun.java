package me.godspunky.skyblock.features.entity.dungeon.Abilities;

import me.godspunky.skyblock.Skyblock;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.util.Vector;

public class BonzoAbilityRun implements Runnable{

    private ArmorStand stand;
    private LivingEntity p;
    private int fly;
    Location loc;
    private Vector vecTo;

    public BonzoAbilityRun(final ArmorStand stand, LivingEntity player, final Vector vecTo) {
        this.fly = 0;
        this.stand = stand;
        this.p = player;
        this.vecTo = vecTo;
        this.fly = 0;

    }


    @Override
    public void run() {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Skyblock.getPlugin(), (Runnable) new Runnable() {
            @Override
            public void run() {
                for (final Entity e : BonzoAbilityRun.this.stand.getNearbyEntities(0.5, 0.5, 0.5)) {
                    LivingEntity e2 = null;
                    if (!(e instanceof Item) && !(e instanceof ExperienceOrb) && !(e instanceof ItemFrame)) {
                        e2 = (LivingEntity) e;
                    }
                    if (!(e instanceof Player) && e2 != null && !(e2 instanceof Villager) && !(e2 instanceof ArmorStand)) {
                        BonzoAbilityRun.this.stand.remove();
                        BonzoAbilityRun.this.p.getWorld().playSound(e2.getLocation(), Sound.FIREWORK_BLAST2, 1.0f, 1.0f);
                        BonzoAbilityRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        BonzoAbilityRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        BonzoAbilityRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        BonzoAbilityRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        BonzoAbilityRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        BonzoAbilityRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        BonzoAbilityRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        BonzoAbilityRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                    }
                }
                if (BonzoAbilityRun.this.stand.getEyeLocation().getBlock().getType() != Material.AIR && BonzoAbilityRun.this.fly == 0) {
                    ++BonzoAbilityRun.this.fly;
                    final Location loc2 = BonzoAbilityRun.this.p.getLocation();
                    final Location loc3 = BonzoAbilityRun.this.stand.getLocation();
                    if (loc3.distance(loc2) < 4.0) {
                        final Vector v = new Vector((loc2.getX() - loc3.getX()) / 3.0, 1.0, (loc2.getZ() - loc3.getZ()) / 3.0);
                        try {
                            BonzoAbilityRun.this.p.setVelocity(v);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    BonzoAbilityRun.this.stand.remove();
                    BonzoAbilityRun.this.p.getWorld().playSound(BonzoAbilityRun.this.stand.getLocation(), Sound.FIREWORK_BLAST2, 1.0f, 5.0f);
                    BonzoAbilityRun.this.p.getWorld().playEffect(BonzoAbilityRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                    BonzoAbilityRun.this.p.getWorld().playEffect(BonzoAbilityRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                    BonzoAbilityRun.this.p.getWorld().playEffect(BonzoAbilityRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                    BonzoAbilityRun.this.p.getWorld().playEffect(BonzoAbilityRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                    BonzoAbilityRun.this.p.getWorld().playEffect(BonzoAbilityRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                    BonzoAbilityRun.this.p.getWorld().playEffect(BonzoAbilityRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                    BonzoAbilityRun.this.p.getWorld().playEffect(BonzoAbilityRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                }
                (BonzoAbilityRun.this.loc = BonzoAbilityRun.this.stand.getLocation()).setYaw(BonzoAbilityRun.this.stand.getLocation().getYaw() + 15.0f);
                BonzoAbilityRun.this.stand.teleport(BonzoAbilityRun.this.loc);
                BonzoAbilityRun.this.stand.teleport(BonzoAbilityRun.this.stand.getLocation().clone().add(BonzoAbilityRun.this.vecTo));
            }
        });
    }

    public static void cancel(int i, ArmorStand stand) {
        Bukkit.getScheduler().cancelTask(i);
        stand.getWorld().playEffect(stand.getEyeLocation(), Effect.SNOWBALL_BREAK, 2);
        stand.getWorld().playEffect(stand.getEyeLocation(), Effect.SNOWBALL_BREAK, 2);
        stand.getWorld().playEffect(stand.getEyeLocation(), Effect.SNOWBALL_BREAK, 2);
        stand.getWorld().playEffect(stand.getEyeLocation(), Effect.SNOWBALL_BREAK, 2);
        stand.remove();
    }

}

