package me.adarsh.godspunkycore.features.entity.caverns;

import me.adarsh.godspunkycore.GodSpunkySkyblockMain;
import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.SlimeStatistics;
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
        }.runTaskLater(GodSpunkySkyblockMain.getPlugin(), 1);
    }

    @Override
    public double getXPDropped() {
        return 15.0;
    }
}