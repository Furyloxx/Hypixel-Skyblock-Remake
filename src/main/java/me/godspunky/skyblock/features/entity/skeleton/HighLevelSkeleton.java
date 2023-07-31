package me.godspunky.skyblock.features.entity.skeleton;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.entity.EntityFunction;
import me.godspunky.skyblock.features.entity.EntityStatistics;
import me.godspunky.skyblock.features.entity.SEntity;
import me.godspunky.skyblock.features.entity.SEntityType;
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
        }.runTaskLater(Skyblock.getPlugin(), 100);
    }
}