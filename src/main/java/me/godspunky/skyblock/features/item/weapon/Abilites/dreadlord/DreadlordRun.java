package me.godspunky.skyblock.features.item.weapon.Abilites.dreadlord;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.user.User;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.util.Vector;

public class DreadlordRun implements Runnable {
    private ArmorStand stand;
    private Player p;
    private int fly;
    Location loc;
    private Vector vecTo;

    public DreadlordRun(final ArmorStand stand, final Player player, final Vector vecTo) {
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
                for (final Entity e : DreadlordRun.this.stand.getNearbyEntities(0.5, 0.5, 0.5)) {
                    LivingEntity e2 = null;
                    if (!(e instanceof Item) && !(e instanceof ExperienceOrb) && !(e instanceof ItemFrame)) {
                        e2 = (LivingEntity) e;
                    }
                    if (!(e instanceof Player) && e2 != null && !(e2 instanceof Villager) && !(e2 instanceof ArmorStand)) {
                        User user = User.getUser(p.getUniqueId());
                        user.damageEntity(e2);
                        DreadlordRun.this.stand.remove();
                        DreadlordRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.SMOKE, 1);
                        DreadlordRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.SMOKE, 1);
                        DreadlordRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.SMOKE, 1);
                        DreadlordRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.SMOKE, 1);
                        DreadlordRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.SMOKE, 1);
                        DreadlordRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.SMOKE, 1);
                        DreadlordRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.SMOKE, 1);
                        DreadlordRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.SMOKE, 1);
                    }
                }
                if (DreadlordRun.this.stand.getEyeLocation().getBlock().getType() != Material.AIR && DreadlordRun.this.fly == 0) {
                    DreadlordRun.this.stand.remove();
                    DreadlordRun.this.p.getWorld().playEffect(DreadlordRun.this.stand.getEyeLocation(), Effect.SMOKE, 10);
                    DreadlordRun.this.p.getWorld().playEffect(DreadlordRun.this.stand.getEyeLocation(), Effect.SMOKE, 10);
                    DreadlordRun.this.p.getWorld().playEffect(DreadlordRun.this.stand.getEyeLocation(), Effect.SMOKE, 10);
                    DreadlordRun.this.p.getWorld().playEffect(DreadlordRun.this.stand.getEyeLocation(), Effect.SMOKE, 10);
                    DreadlordRun.this.p.getWorld().playEffect(DreadlordRun.this.stand.getEyeLocation(), Effect.SMOKE, 10);
                    DreadlordRun.this.p.getWorld().playEffect(DreadlordRun.this.stand.getEyeLocation(), Effect.SMOKE, 10);
                    DreadlordRun.this.p.getWorld().playEffect(DreadlordRun.this.stand.getEyeLocation(), Effect.SMOKE, 10);
                }
                (DreadlordRun.this.loc = DreadlordRun.this.stand.getLocation()).setYaw(DreadlordRun.this.stand.getLocation().getYaw() + 15.0f);
                DreadlordRun.this.stand.teleport(DreadlordRun.this.loc);
                DreadlordRun.this.stand.teleport(DreadlordRun.this.stand.getLocation().clone().add(DreadlordRun.this.vecTo));
            }
        });
    }

    public static void cancel(int i, ArmorStand stand) {
        Bukkit.getScheduler().cancelTask(i);
        stand.getWorld().playEffect(stand.getEyeLocation(), Effect.SMOKE, 2);
        stand.getWorld().playEffect(stand.getEyeLocation(), Effect.SMOKE, 2);
        stand.getWorld().playEffect(stand.getEyeLocation(), Effect.SMOKE, 2);
        stand.getWorld().playEffect(stand.getEyeLocation(), Effect.SMOKE, 2);
        stand.remove();
    }

}
