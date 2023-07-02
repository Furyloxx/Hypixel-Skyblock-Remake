package me.adarsh.godspunkycore.features.entity;

import com.mojang.authlib.GameProfile;
import lombok.Getter;
import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.entity.end.EndermanStatistics;
import me.adarsh.godspunkycore.features.entity.nms.SNMSEntity;
import me.adarsh.godspunkycore.features.entity.wolf.WolfStatistics;
import me.adarsh.godspunkycore.util.SUtil;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.entity.*;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class SEntity // 3, 4, 5
{
    private static final Skyblock plugin = Skyblock.getPlugin();

    private final SEntityType specType;
    private final LivingEntity entity;
    private final Map<UUID, Double> damageDealt;
    private BukkitTask task;
    private BukkitTask ticker;
    private Object genericInstance;
    private EntityStatistics statistics;
    private EntityFunction function;

    public SEntity(Location location, SEntityType specType, Object... params) {
        this.specType = specType;
        Object instance = specType.instance(params);
        this.genericInstance = instance;
        EntityFunction function = (EntityFunction) instance;
        EntityStatistics statistics = (EntityStatistics) instance;
        this.function = function;
        this.statistics = statistics;
        if (instance instanceof SNMSEntity)
            this.entity = ((SNMSEntity) instance).spawn(location);
        else
            this.entity = (LivingEntity) location.getWorld().spawnEntity(location, specType.getCraftType());
        this.damageDealt = new HashMap<>();
        if (statistics.getMovementSpeed() != -1.0)
            ((CraftLivingEntity) entity).getHandle().getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(statistics.getMovementSpeed());
        Location move = this.entity.getLocation().clone();
        move.setYaw(((Double) SUtil.random(0.0, 360.0)).floatValue());
        this.entity.teleport(move);
        SEntityEquipment equipment = statistics.getEntityEquipment();
        EntityEquipment ee = this.entity.getEquipment();
        if (equipment != null) {
            ee.setHelmet(equipment.getHelmet());
            ee.setChestplate(equipment.getChestplate());
            ee.setLeggings(equipment.getLeggings());
            ee.setBoots(equipment.getBoots());
            ee.setItemInHand(equipment.getItemInHand());
        }
        this.entity.setRemoveWhenFarAway(statistics.removeWhenFarAway());
        function.onSpawn(entity, this);
        if (function.tick(entity)) {
            this.ticker = new BukkitRunnable() {
                public void run() {
                    if (entity.isDead())
                        cancel();
                    function.tick(entity);
                }
            }.runTaskTimer(Skyblock.getPlugin(), 0, 1);
        }
        if (statistics instanceof SlimeStatistics && this.entity instanceof Slime)
            ((Slime) this.entity).setSize(((SlimeStatistics) statistics).getSize());
        if (statistics instanceof EndermanStatistics && this.entity instanceof Enderman)
            ((Enderman) this.entity).setCarriedMaterial(((EndermanStatistics) statistics).getCarriedMaterial() != null ? ((EndermanStatistics) statistics).getCarriedMaterial() : new MaterialData(Material.AIR));
        if (this.entity instanceof org.bukkit.entity.Ageable) {
            if (genericInstance instanceof Ageable && ((Ageable) genericInstance).isBaby())
                ((org.bukkit.entity.Ageable) this.entity).setBaby();
            else
                ((org.bukkit.entity.Ageable) this.entity).setAdult();
        }
        if (statistics instanceof ZombieStatistics && this.entity instanceof Zombie)
            ((Zombie) this.entity).setVillager(((ZombieStatistics) statistics).isVillager());
        if (statistics instanceof JockeyStatistics)
            this.entity.setPassenger(new SEntity(location, ((JockeyStatistics) statistics).getPassenger()).getEntity());
        if (statistics instanceof WolfStatistics && this.entity instanceof Wolf)
            ((Wolf) this.entity).setAngry(((WolfStatistics) statistics).isAngry());
        if (statistics instanceof SkeletonStatistics && this.entity instanceof Skeleton)
            ((Skeleton) this.entity).setSkeletonType(((SkeletonStatistics) statistics).isWither() ? Skeleton.SkeletonType.WITHER : Skeleton.SkeletonType.NORMAL);
        new BukkitRunnable() {
            public void run() {
                if (!statistics.isVisible())
                    ((CraftLivingEntity) entity).getHandle().setInvisible(true);
            }
        }.runTaskLater(Skyblock.getPlugin(), 2);
        this.entity.setMaxHealth(statistics.getEntityMaxHealth());
        this.entity.setHealth(this.entity.getMaxHealth());
        this.entity.setMetadata("specEntityObject", new FixedMetadataValue(plugin, this));
        if (statistics.hasNameTag()) {
            if (entity instanceof EnderDragon) {
                entity.setCustomName(ChatColor.RED + statistics.getEntityName());
                return;
            }
            this.entity.setCustomNameVisible(true);
            this.task = new BukkitRunnable() {
                public void run() {
                    entity.setCustomName(ChatColor.RED + statistics.getEntityName() + " " + ChatColor.GREEN + (int) entity.getHealth() +
                            ChatColor.WHITE + "/" + ChatColor.GREEN + (int) entity.getMaxHealth() + ChatColor.RED + "❤");
                }
            }.runTaskTimer(Skyblock.getPlugin(), 0, 10);
        }
    }

    public SEntity(Entity e, SEntityType type, Object... params) {
        this(e.getLocation(), type, params);
    }

    public void addDamageFor(Player player, double damage) {
        UUID uuid = player.getUniqueId();
        if (damageDealt.containsKey(uuid))
            damage += damageDealt.get(uuid);
        damageDealt.remove(uuid);
        damageDealt.put(uuid, damage);
    }

    public void setVisible(boolean visible) {
        new BukkitRunnable() {
            public void run() {
                ((CraftLivingEntity) entity).getHandle().setInvisible(!visible);
            }
        }.runTaskLater(Skyblock.getPlugin(), 2);
    }

    public void setTarget(LivingEntity target) {
        if (!(entity instanceof Creature)) return;
        ((Creature) entity).setTarget(target);
    }

    public void remove() {
        if (this.ticker != null)
            this.ticker.cancel();
        if (this.task != null)
            this.task.cancel();
        entity.remove();
    }

    public static SEntity findSEntity(Entity entity) {
        if (!entity.hasMetadata("specEntityObject") ||
                entity.getMetadata("specEntityObject").size() == 0 ||
                !(entity.getMetadata("specEntityObject").get(0).value() instanceof SEntity))
            return null;
        return (SEntity) entity.getMetadata("specEntityObject").get(0).value();
    }
}