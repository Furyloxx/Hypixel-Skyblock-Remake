package me.adarsh.godspunkycore.entity.nms;

import me.adarsh.godspunkycore.GodSpunkySkyblockMain;
import me.adarsh.godspunkycore.entity.EntityStatistics;
import me.adarsh.godspunkycore.entity.SEntity;
import me.adarsh.godspunkycore.entity.caverns.CreeperFunction;
import me.adarsh.godspunkycore.event.CreeperIgniteEvent;
import net.minecraft.server.v1_8_R3.EntityCreeper;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;

public class SneakyCreeper extends EntityCreeper implements EntityStatistics, SNMSEntity, CreeperFunction {
    public SneakyCreeper(World world) {
        super(world);
    }

    public SneakyCreeper() {
        this(((CraftWorld) Bukkit.getWorlds().get(0)).getHandle());
    }

    @Override
    public String getEntityName() {
        return "Sneaky Creeper";
    }

    @Override
    public double getEntityMaxHealth() {
        return 120.0;
    }

    @Override
    public double getDamageDealt() {
        return 80.0;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public void t_() {
        try {
            Field f = EntityCreeper.class.getDeclaredField("fuseTicks");
            f.setAccessible(true);
            int fuseTicks = (int) f.get(this);
            if (cm() > 0 && fuseTicks == 0) {
                CreeperIgniteEvent ignite = new CreeperIgniteEvent((Creeper) this.getBukkitEntity());
                GodSpunkySkyblockMain.getPlugin().getServer().getPluginManager().callEvent(ignite);
                if (ignite.isCancelled())
                    return;
            }
        } catch (IllegalAccessException | NoSuchFieldException ignored) {
        }
        super.t_();
    }

    @Override
    public void onCreeperIgnite(CreeperIgniteEvent e, SEntity sEntity) {
        sEntity.setVisible(true);
        new BukkitRunnable() {
            public void run() {
                if (e.getEntity().isDead())
                    return;
                sEntity.setVisible(false);
            }
        }.runTaskLater(GodSpunkySkyblockMain.getPlugin(), 35);
    }

    @Override
    public LivingEntity spawn(Location location) {
        this.world = ((CraftWorld) location.getWorld()).getHandle();
        this.setPosition(location.getX(), location.getY(), location.getZ());
        this.world.addEntity(this, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (LivingEntity) this.getBukkitEntity();
    }

    public double getXPDropped() {
        return 8.0;
    }
}