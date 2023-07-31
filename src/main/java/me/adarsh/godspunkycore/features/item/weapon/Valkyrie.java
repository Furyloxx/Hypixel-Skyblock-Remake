package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.item.*;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.EntityHuman;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftHumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashSet;

public class Valkyrie implements ToolStatistics, MaterialFunction, Ability {
    public int getBaseDamage() {
        return 270;
    }

    public double getBaseStrength() {
        return 145.0D;
    }

    public double getBaseIntelligence() {
        return 60.0D;
    }

    public double getBaseFerocity() {
        return 60.0D;
    }

    public String getDisplayName() {
        return "Valkyrie";
    }

    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }

    public String getLore() {
        return "Deals " + ChatColor.RED + "+50% " + ChatColor.GRAY + "damage to withers. Grants " + ChatColor.RED + "+1 Damage " + ChatColor.GRAY + "and" + ChatColor.GREEN + " +1" + ChatColor.RED + " ❁ Strength " + ChatColor.GRAY + "per" + ChatColor.RED + " Catacombs " + ChatColor.GRAY + "level.";
    }

    public String getAbilityName() {
        return "Wither Impact";
    }

    public String getAbilityDescription() {
        return "Teleports " + ChatColor.GREEN + "10 blocks" + ChatColor.GRAY + " ahead of you. Then implode dealing " + ChatColor.RED + "10,000" + ChatColor.GRAY + " damage to nearby enemies. Also applies the " + ChatColor.GOLD + "wither shield" + ChatColor.GRAY + " scroll ability reducing damage taken and granting an " + ChatColor.GOLD + "❤ " + ChatColor.GOLD + "Absorption" + ChatColor.GRAY + " shield for " + ChatColor.YELLOW + "5" + ChatColor.GRAY + " seconds.";
    }


    @Override
    public void onAbilityUse(Player p, SItem sItem) {
        Location loc = p.getLocation();
        HashSet<Byte> hashSet = new HashSet<>();
        hashSet.add((byte) 0);
        Block block = p.getTargetBlock(hashSet, 8);
        Location playerLocation = p.getLocation();
        Location teleportLocation = new Location(block.getWorld(), block.getX(), block.getY(), block.getZ(), playerLocation.getYaw(), playerLocation.getPitch());
        if (teleportLocation.getBlock().getType() != Material.AIR) {
            teleportLocation.setY(teleportLocation.getY() + 1.0D);
        }

        if (new Location(teleportLocation.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1.0D, teleportLocation.getZ()).getBlock().getType() == Material.AIR && p.getLocation().add(p.getLocation().getDirection()).getBlock().getType() == Material.AIR) {
            teleportLocation.setX(teleportLocation.getX() - 0.5D);
            teleportLocation.setZ(teleportLocation.getZ() - 0.5D);
        } else {
            teleportLocation.setX(teleportLocation.getX() + 0.5D);
            teleportLocation.setZ(teleportLocation.getZ() + 0.5D);
        }
        p.teleport(teleportLocation);
        EntityHuman human = ((CraftHumanEntity) p).getHandle();
        human.setAbsorptionHearts(10);


        AbilityDamage.DamageNearByEntity(p , 5 , teleportLocation);
        new BukkitRunnable() {
            @Override
            public void run() {
                human.setAbsorptionHearts(0);
            }
        }.runTaskLater(Skyblock.getPlugin(), 100);
    }

    public int getAbilityCooldownTicks() {
        return 3;
    }

    public int getManaCost() {
        return 300;
    }

    private void createCircle(Player player, double radius, int distance) {
        Vector dist = player.getEyeLocation().getDirection().multiply(distance);
        Location mid = player.getEyeLocation().add(dist);
        int particles = 18;
        for (int i = 0; i < particles; i++) {
            double angle = 6.283185307179586D * i / particles;
            double x = Math.cos(angle) * radius;
            double y = Math.sin(angle) * radius;
            Vector v = rotateAroundAxisX(new Vector(x, y, 0.0D), player.getEyeLocation().getPitch());
            v = rotateAroundAxisY(v, player.getEyeLocation().getYaw());
            Location temp = mid.clone().add(v);
            player.getWorld().spigot().playEffect(temp, Effect.WITCH_MAGIC, 0, 1, 1.0F, 1.0F, 1.0F, 0.0F, 0, 64);
        }
    }

    private Vector rotateAroundAxisX(Vector v, double angle) {
        angle = Math.toRadians(angle);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double y = v.getY() * cos - v.getZ() * sin;
        double z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }

    private Vector rotateAroundAxisY(Vector v, double angle) {
        angle = -angle;
        angle = Math.toRadians(angle);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double x = v.getX() * cos + v.getZ() * sin;
        double z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }
}
