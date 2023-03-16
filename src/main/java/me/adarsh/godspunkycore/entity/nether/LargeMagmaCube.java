package me.adarsh.godspunkycore.entity.nether;

import me.adarsh.godspunkycore.GodSpunkySkyblockMain;
import me.adarsh.godspunkycore.entity.EntityFunction;
import me.adarsh.godspunkycore.entity.SEntity;
import me.adarsh.godspunkycore.entity.SlimeStatistics;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftMagmaCube;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

public class LargeMagmaCube implements SlimeStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Magma Cube";
    }

    @Override
    public double getEntityMaxHealth() {
        return 300.0;
    }

    @Override
    public double getDamageDealt() {
        return 150.0;
    }

    @Override
    public double getXPDropped() {
        return 4.0;
    }

    @Override
    public void onTarget(SEntity sEntity, EntityTargetLivingEntityEvent e) {
        LivingEntity entity = (LivingEntity) e.getEntity();
        Entity found = e.getTarget();
        new BukkitRunnable() {
            public void run() {
                if (entity.isDead()) {
                    cancel();
                    return;
                }
                Entity target = ((CraftMagmaCube) entity).getHandle().getGoalTarget().getBukkitEntity();
                if (!found.equals(target)) {
                    cancel();
                    return;
                }
                for (int i = 0; i < 3; i++) {
                    new BukkitRunnable() {
                        public void run() {
                            if (entity.isDead()) {
                                cancel();
                                return;
                            }
                            Fireball fireball = entity.getWorld().spawn(entity.getEyeLocation().add(
                                    entity.getEyeLocation().getDirection().multiply(3.0)), Fireball.class);
                            fireball.setMetadata("magma", new FixedMetadataValue(GodSpunkySkyblockMain.getPlugin(), sEntity));
                            fireball.setDirection(target.getLocation().getDirection().multiply(-1.0).normalize());
                        }
                    }.runTaskLater(GodSpunkySkyblockMain.getPlugin(), (i + 1) * 10);
                }
            }
        }.runTaskTimer(GodSpunkySkyblockMain.getPlugin(), 60, 100);
    }

    @Override
    public int getSize() {
        return 6;
    }

    @Override
    public boolean split() {
        return false;
    }
}