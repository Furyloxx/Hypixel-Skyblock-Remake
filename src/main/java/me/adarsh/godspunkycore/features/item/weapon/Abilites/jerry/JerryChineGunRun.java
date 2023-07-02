package me.adarsh.godspunkycore.features.item.weapon.Abilites.jerry;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.user.User;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.util.Vector;

public class JerryChineGunRun implements Runnable
{
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
        Bukkit.getScheduler().scheduleSyncDelayedTask(Skyblock.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                for (final Entity e : JerryChineGunRun.this.stand.getNearbyEntities(0.5, 0.5, 0.5)) {
                    LivingEntity e2 = null;
                    if (!(e instanceof Item) && !(e instanceof ExperienceOrb) && !(e instanceof ItemFrame)) {
                        e2 = (LivingEntity)e;
                    }
                    if (!(e instanceof Player) && e2 != null && !(e2 instanceof Villager) && !(e2 instanceof ArmorStand)) {

                        JerryChineGunRun.this.stand.remove();
                        JerryChineGunRun.this.p.getWorld().playSound(e2.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        JerryChineGunRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                        User user = User.getUser(p.getUniqueId());
                        user.damageEntity((LivingEntity) e, 500.0);
                    }
                }
                (JerryChineGunRun.this.loc = JerryChineGunRun.this.stand.getLocation()).setYaw(JerryChineGunRun.this.stand.getLocation().getYaw() + 15.0f);
                JerryChineGunRun.this.stand.teleport(JerryChineGunRun.this.loc);
                JerryChineGunRun.this.stand.teleport(JerryChineGunRun.this.stand.getLocation().clone().add(JerryChineGunRun.this.vecTo));
            }
        });
    }


    public static void cancel(int i, ArmorStand stand) {
        Bukkit.getScheduler().cancelTask(i);
        stand.getWorld().playEffect(stand.getEyeLocation(), Effect.HAPPY_VILLAGER, 2);
        stand.getWorld().playEffect(stand.getEyeLocation(), Effect.HAPPY_VILLAGER, 2);
        stand.getWorld().playEffect(stand.getEyeLocation(), Effect.HAPPY_VILLAGER, 2);
        stand.getWorld().playEffect(stand.getEyeLocation(), Effect.HAPPY_VILLAGER, 2);
        stand.remove();

    }
}