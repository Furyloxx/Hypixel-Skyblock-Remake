package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.PacketEntityManager;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityBat;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Set;

public class SpiritSceptre implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Spirit Sceptre";
    }

    @Override
    public int getBaseDamage() {
        return 180;
    }

    @Override
    public double getBaseIntelligence(){return 300;}

    @Override
    public int getManaCost() {
        return 200;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public String getAbilityName() {
        return "Guided Bat";
    }

    @Override
    public String getAbilityDescription() {
        return "Shoots a guided spirit bat, following your aim and exploding for 2,000 damage.";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public void onAbilityUse(Player p, SItem sItem) {
        p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1.0f, 1.0f);
        Location spawn = p.getLocation();
        EntityBat bat = new EntityBat((World)((CraftWorld)spawn.getWorld()).getHandle());
        bat.setLocation(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 0.0f, 0.0f);
        PacketEntityManager packetManager = new PacketEntityManager((Entity)bat);
        bat.setAsleep(false);
        packetManager.updateLocation();
        Long time = System.currentTimeMillis();
        new BukkitRunnable() {
            public void run() {
                Location location = p.getTargetBlock((Set<Material>) null, 40).getLocation();
                if (bat.getBukkitEntity().getLocation().getBlock().getType() != Material.AIR || p.getLocation().distance(bat.getBukkitEntity().getLocation()) > 35.0 || System.currentTimeMillis() - time > 10000L) {
                    packetManager.destroy();
                    for (final org.bukkit.entity.Entity e : bat.getBukkitEntity().getNearbyEntities(4.0, 4.0, 4.0)) {
                        if (!(e instanceof Player) && !(e instanceof EnderDragonPart) && !(e instanceof Villager) && !(e instanceof ArmorStand) && !(e instanceof ExperienceOrb)) {
                            if (!(e instanceof LivingEntity)) {
                                continue;
                            }
                           User user = User.getUser(p.getUniqueId());
                            user.damageEntity((LivingEntity) e);
                        }
                    }
                    this.cancel();
                    bat.getBukkitEntity().getLocation().getWorld().playEffect(bat.getBukkitEntity().getLocation(), Effect.EXPLOSION_HUGE, 2);
                    p.playSound(p.getLocation(), Sound.EXPLODE, 1.0f, 1.0f);
                }
                for (org.bukkit.entity.Entity e : bat.getBukkitEntity().getNearbyEntities(1.0, 1.0, 1.0)) {
                    if (!(e instanceof Player) && !(e instanceof EnderDragonPart) && !(e instanceof Villager) && !(e instanceof ArmorStand) && !(e instanceof ExperienceOrb)) {
                        if (!(e instanceof LivingEntity)) {
                            continue;
                        }
                        for (final org.bukkit.entity.Entity e2 : bat.getBukkitEntity().getNearbyEntities(4.0, 4.0, 4.0)) {
                            if (!(e2 instanceof Player) && !(e2 instanceof EnderDragonPart) && !(e2 instanceof Villager) && !(e2 instanceof ArmorStand) && !(e2 instanceof ExperienceOrb)) {
                                if (!(e2 instanceof LivingEntity)) {
                                    continue;
                                }
                               User user = User.getUser(p.getUniqueId());
                                user.damageEntity((LivingEntity) e2);
                            }
                        }
                        packetManager.destroy();
                        this.cancel();
                        bat.getBukkitEntity().getLocation().getWorld().playEffect(bat.getBukkitEntity().getLocation(), Effect.EXPLOSION_HUGE, 2);
                        p.playSound(p.getLocation(), Sound.EXPLODE, 1.0f, 1.0f);
                        break;
                    }
                }
                Vector batVector = bat.getBukkitEntity().getLocation().toVector();
                Vector vector = location.toVector().clone().subtract(batVector).normalize().multiply(1);
                batVector.add(vector);
                bat.setLocation(batVector.getX(), batVector.getY(), batVector.getZ(), p.getLocation().getYaw(), 0.0f);
                packetManager.updateLocation();
            }
        }.runTaskTimer(Skyblock.getPlugin(), 1L, 1L);
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }

    @Override
    public String getLore() {
        return null;
    }
}
