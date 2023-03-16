package me.adarsh.godspunkycore.entity.skeleton;

import me.adarsh.godspunkycore.GodSpunkySkyblockMain;
import me.adarsh.godspunkycore.entity.EntityFunction;
import me.adarsh.godspunkycore.entity.EntityStatistics;
import me.adarsh.godspunkycore.entity.SEntity;
import me.adarsh.godspunkycore.entity.SEntityType;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class HighLevelSkeleton implements EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Skeleton";
    }

    @Override
    public double getEntityMaxHealth() {
        return 200.0;
    }

    @Override
    public double getDamageDealt() {
        return 47.0;
    }

    @Override
    public double getXPDropped() {
        return 6.0;
    }

    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
        Item item = sEntity.getEntity().getWorld().dropItem(sEntity.getEntity().getLocation(), new ItemStack(Material.BONE, 2));
        new BukkitRunnable() {
            public void run() {
                if (item.isDead())
                    return;
                Location spawn = item.getLocation().clone().add(0, 1, 0);
                for (int i = 0; i < 5; i++)
                    item.getWorld().spigot().playEffect(spawn, Effect.PARTICLE_SMOKE, 0, 1, 0f, 0f, 0f, 0f, 1, 20);
                new SEntity(spawn, SEntityType.HIGH_LEVEL_SKELETON);
                item.remove();
            }
        }.runTaskLater(GodSpunkySkyblockMain.getPlugin(), 100);
    }
}