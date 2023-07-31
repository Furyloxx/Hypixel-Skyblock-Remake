package me.godspunky.skyblock.features.entity.den;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.entity.EntityDrop;
import me.godspunky.skyblock.features.entity.EntityDropType;
import me.godspunky.skyblock.features.entity.SEntity;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collections;
import java.util.List;

public class MutantTarantula extends BaseSpider {
    @Override
    public String getEntityName() {
        return ChatColor.RED + "Mutant Tarantula";
    }

    @Override
    public double getEntityMaxHealth() {
        return 576000;
    }

    @Override
    public double getDamageDealt() {
        return 5000.0;
    }

    @Override
    public double getXPDropped() {
        return 500.0;
    }

    @Override
    public void onSpawn(LivingEntity entity, SEntity sEntity) {
        new BukkitRunnable() {
            public void run() {
                if (entity.isDead()) {
                    cancel();
                    return;
                }
                for (Entity e : entity.getNearbyEntities(1, 1, 1)) {
                    if (!(e instanceof Player)) return;
                    ((Player) e).damage(getDamageDealt() * 0.5, entity);
                }
            }
        }.runTaskTimer(Skyblock.getPlugin(), 20, 20);
    }

    @Override
    public List<EntityDrop> drops() {
        return Collections.singletonList(new EntityDrop(SUtil.setStackAmount(SItem.of(SMaterial.TARANTULA_WEB).getStack(), 5), EntityDropType.GUARANTEED, 1.0));
    }
}