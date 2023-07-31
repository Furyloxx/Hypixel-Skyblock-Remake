package me.godspunky.skyblock.features.entity.caverns;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.entity.EntityFunction;
import me.godspunky.skyblock.features.entity.SlimeStatistics;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class MediumSlime implements SlimeStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Slime";
    }

    @Override
    public double getEntityMaxHealth() {
        return 150.0;
    }

    @Override
    public double getDamageDealt() {
        return 100.0;
    }

    @Override
    public int getSize() {
        return 7;
    }

    @Override
    public void onAttack(EntityDamageByEntityEvent e) {
        new BukkitRunnable() {
            public void run() {
                e.getEntity().setVelocity(e.getEntity().getVelocity().clone().setY(1.5));
            }
        }.runTaskLater(Skyblock.getPlugin(), 1);
    }

    @Override
    public double getXPDropped() {
        return 15.0;
    }
}