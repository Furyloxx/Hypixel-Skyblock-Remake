package me.godspunky.skyblock.features.item.weapon.Abilites.jerry;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.user.User;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.util.Vector;


public class JerryChineGunRun implements Runnable {
    private ArmorStand stand;
    private Player p;
    private int fly;
    Location loc;
    private Vector vecTo;

    public JerryChineGunRun(final ArmorStand stand, final Player player, final Vector vecTo) {
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
                for (final Entity e : JerryChineGunRun.this.stand.getNearbyEntities(0.5, 0.5, 0.5)) {
                    LivingEntity e2 = null;
                    if (!(e instanceof Item) && !(e instanceof ExperienceOrb) && !(e instanceof ItemFrame)) {
                        e2 = (LivingEntity) e;
                    }
                    if (!(e instanceof Player) && e2 != null && !(e2 instanceof Villager) && !(e2 instanceof ArmorStand)) {
                        User user = User.getUser(p.getUniqueId());
                        user.damageEntity(e2);
                        JerryChineGunRun.this.stand.remove();
                        JerryChineGunRun.this.p.getWorld().playSound(e2.getLocation(), Sound.FIREWORK_BLAST2, 1.0f, 1.0f);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                    }
                }
                if (JerryChineGunRun.this.stand.getEyeLocation().getBlock().getType() != Material.AIR && JerryChineGunRun.this.fly == 0) {
                    JerryChineGunRun.this.stand.remove();
                    JerryChineGunRun.this.p.getWorld().playSound(JerryChineGunRun.this.stand.getLocation(), Sound.FIREWORK_BLAST2, 1.0f, 5.0f);
                    JerryChineGunRun.this.p.getWorld().playEffect(JerryChineGunRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                    JerryChineGunRun.this.p.getWorld().playEffect(JerryChineGunRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                    JerryChineGunRun.this.p.getWorld().playEffect(JerryChineGunRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                    JerryChineGunRun.this.p.getWorld().playEffect(JerryChineGunRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                    JerryChineGunRun.this.p.getWorld().playEffect(JerryChineGunRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                    JerryChineGunRun.this.p.getWorld().playEffect(JerryChineGunRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                    JerryChineGunRun.this.p.getWorld().playEffect(JerryChineGunRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                }
                (JerryChineGunRun.this.loc = JerryChineGunRun.this.stand.getLocation()).setYaw(JerryChineGunRun.this.stand.getLocation().getYaw() + 15.0f);
                JerryChineGunRun.this.stand.teleport(JerryChineGunRun.this.loc);
                JerryChineGunRun.this.stand.teleport(JerryChineGunRun.this.stand.getLocation().clone().add(JerryChineGunRun.this.vecTo));
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
