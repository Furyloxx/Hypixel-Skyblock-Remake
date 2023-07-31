package me.godspunky.skyblock.features.item;

import me.godspunky.skyblock.user.User;
import org.bukkit.Location;
import org.bukkit.entity.*;

public class AbilityDamage {


    public static void DamageNearbyEntity(LivingEntity entity, Player p , double radius) {
        for (org.bukkit.entity.Entity e : entity.getNearbyEntities(radius, radius, radius)) {
            if (!(e instanceof Player) && !(e instanceof EnderDragonPart) && !(e instanceof Villager) && !(e instanceof ArmorStand) && !(e instanceof ExperienceOrb)) {
                if (!(e instanceof LivingEntity)) {
                    continue;
                }
                for (final org.bukkit.entity.Entity e2 : entity.getNearbyEntities(4.0, 4.0, 4.0)) {
                    if (!(e2 instanceof Player) && !(e2 instanceof EnderDragonPart) && !(e2 instanceof Villager) && !(e2 instanceof ArmorStand) && !(e2 instanceof ExperienceOrb)) {
                        if (!(e2 instanceof LivingEntity)) {
                            continue;
                        }
                        User user = User.getUser(p.getUniqueId());
                        user.damageEntity((LivingEntity) e2);
                    }
                }
            }
        }
    }

    public static void DamageNearByEntity(Player p , double radius) {
        for (org.bukkit.entity.Entity e : p.getNearbyEntities(radius, radius, radius)) {
            if (!(e instanceof Player) && !(e instanceof EnderDragonPart) && !(e instanceof Villager) && !(e instanceof ArmorStand) && !(e instanceof ExperienceOrb)) {
                if (!(e instanceof LivingEntity)) {
                    continue;
                }
                for (final org.bukkit.entity.Entity e2 : p.getNearbyEntities(4.0, 4.0, 4.0)) {
                    if (!(e2 instanceof Player) && !(e2 instanceof EnderDragonPart) && !(e2 instanceof Villager) && !(e2 instanceof ArmorStand) && !(e2 instanceof ExperienceOrb)) {
                        if (!(e2 instanceof LivingEntity)) {
                            continue;
                        }
                        User user = User.getUser(p.getUniqueId());
                        user.damageEntity((LivingEntity) e2);
                    }
                }
            }
        }
    }
    public static void DamageNearByEntity(Player p , double radius , Location loc) {
        for (org.bukkit.entity.Entity e : p.getWorld().getNearbyEntities(loc,radius, radius, radius)) {
            if (!(e instanceof Player) && !(e instanceof EnderDragonPart) && !(e instanceof Villager) && !(e instanceof ArmorStand) && !(e instanceof ExperienceOrb)) {
                if (!(e instanceof LivingEntity)) {
                    continue;
                }
                for (final org.bukkit.entity.Entity e2 : p.getNearbyEntities(4.0, 4.0, 4.0)) {
                    if (!(e2 instanceof Player) && !(e2 instanceof EnderDragonPart) && !(e2 instanceof Villager) && !(e2 instanceof ArmorStand) && !(e2 instanceof ExperienceOrb)) {
                        if (!(e2 instanceof LivingEntity)) {
                            continue;
                        }
                        User user = User.getUser(p.getUniqueId());
                        user.damageEntity((LivingEntity) e2);
                    }
                }
            }
        }
    }
}










