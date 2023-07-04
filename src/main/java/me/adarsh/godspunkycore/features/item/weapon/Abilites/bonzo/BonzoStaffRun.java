package me.adarsh.godspunkycore.features.item.weapon.Abilites.bonzo;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.user.User;
import org.bukkit.*;
import org.bukkit.entity.*;

import org.bukkit.util.Vector;


public class BonzoStaffRun implements Runnable
{
    private ArmorStand stand;
    private Player p;
    private int fly;
    Location loc;
    private Vector vecTo;

    public BonzoStaffRun(final ArmorStand stand, final Player player, final Vector vecTo) {
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
                        for (final Entity e : BonzoStaffRun.this.stand.getNearbyEntities(0.5, 0.5, 0.5)) {
                            LivingEntity e2 = null;
                            if (!(e instanceof Item) && !(e instanceof ExperienceOrb) && !(e instanceof ItemFrame)) {
                                e2 = (LivingEntity) e;
                            }
                            if (!(e instanceof Player) && e2 != null && !(e2 instanceof Villager) && !(e2 instanceof ArmorStand)) {
                                User user = User.getUser(p.getUniqueId());
                                user.damageEntity(e2);
                                BonzoStaffRun.this.stand.remove();
                                BonzoStaffRun.this.p.getWorld().playSound(e2.getLocation(), Sound.FIREWORK_BLAST2, 1.0f, 1.0f);
                                BonzoStaffRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                                BonzoStaffRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                                BonzoStaffRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                                BonzoStaffRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                                BonzoStaffRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                                BonzoStaffRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                                BonzoStaffRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                                BonzoStaffRun.this.p.getWorld().playEffect(e2.getEyeLocation(), Effect.FIREWORKS_SPARK, 1);
                            }
                        }
                        if (BonzoStaffRun.this.stand.getEyeLocation().getBlock().getType() != Material.AIR && BonzoStaffRun.this.fly == 0) {
                            ++BonzoStaffRun.this.fly;
                            final Location loc2 = BonzoStaffRun.this.p.getLocation();
                            final Location loc3 = BonzoStaffRun.this.stand.getLocation();
                            if (loc3.distance(loc2) < 4.0) {
                                final Vector v = new Vector((loc2.getX() - loc3.getX()) / 3.0, 1.0, (loc2.getZ() - loc3.getZ()) / 3.0);
                                try {
                                    BonzoStaffRun.this.p.setVelocity(v);
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            BonzoStaffRun.this.stand.remove();
                            BonzoStaffRun.this.p.getWorld().playSound(BonzoStaffRun.this.stand.getLocation(), Sound.FIREWORK_BLAST2, 1.0f, 5.0f);
                            BonzoStaffRun.this.p.getWorld().playEffect(BonzoStaffRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                            BonzoStaffRun.this.p.getWorld().playEffect(BonzoStaffRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                            BonzoStaffRun.this.p.getWorld().playEffect(BonzoStaffRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                            BonzoStaffRun.this.p.getWorld().playEffect(BonzoStaffRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                            BonzoStaffRun.this.p.getWorld().playEffect(BonzoStaffRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                            BonzoStaffRun.this.p.getWorld().playEffect(BonzoStaffRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                            BonzoStaffRun.this.p.getWorld().playEffect(BonzoStaffRun.this.stand.getEyeLocation(), Effect.FIREWORKS_SPARK, 10);
                        }
                        (BonzoStaffRun.this.loc = BonzoStaffRun.this.stand.getLocation()).setYaw(BonzoStaffRun.this.stand.getLocation().getYaw() + 15.0f);
                        BonzoStaffRun.this.stand.teleport(BonzoStaffRun.this.loc);
                        BonzoStaffRun.this.stand.teleport(BonzoStaffRun.this.stand.getLocation().clone().add(BonzoStaffRun.this.vecTo));
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
