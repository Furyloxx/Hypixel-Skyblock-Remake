package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.item.*;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class SoulWhip implements ToolStatistics, MaterialFunction, Ability {
    public String getAbilityName() {
        return "Flay";
    }

    public static final Map<UUID, Boolean> cd = new HashMap<>();

    public static final Map<Integer, Boolean> hit = new HashMap<>();

    public String getAbilityDescription() {
        return "Flay your whip in an arc, dealing your melee damage to all enemies in its path";
    }

    public int getAbilityCooldownTicks() {
        return 0;
    }

    public void onAbilityUse(final Player player, final SItem sItem) {
        final Player p = player;
        if (!cd.containsKey(p.getUniqueId())) {
            cd.put(p.getUniqueId(), Boolean.valueOf(true));
            final Vector v = p.getLocation().getDirection().normalize().multiply(0.15D);
            final Location loc = p.getLocation().clone().add(0.0D, 1.55D, 0.0D);
            final World world = loc.getWorld();
            p.playSound(loc, Sound.CAT_HISS, 0.2F, 10.0F);
            (new BukkitRunnable() {
                int count = 0;

                public void run() {
                    Iterator<Entity> packetx = world.getNearbyEntities(loc, 1.0D, 1.0D, 1.0D).iterator();
                    while (packetx.hasNext()) {
                        final Entity e = packetx.next();
                        if (e instanceof LivingEntity && !(e instanceof Player) && !(e instanceof org.bukkit.entity.ExperienceOrb) && !(e instanceof org.bukkit.entity.ArmorStand) && !(e instanceof org.bukkit.entity.Villager) && !e.isDead() && !e.hasMetadata("NPC") && !e.hasMetadata("GiantSword") && !SoulWhip.hit.containsKey(Integer.valueOf(e.getEntityId()))) {
                            SoulWhip.hit.put(Integer.valueOf(e.getEntityId()), Boolean.valueOf(true));
                            (new BukkitRunnable() {
                                public void run() {
                                }
                            }).runTaskLater((Plugin) Skyblock.getPlugin(), 0L);
                            (new BukkitRunnable() {
                                public void run() {
                                    SoulWhip.hit.remove(Integer.valueOf(e.getEntityId()));
                                }
                            }).runTaskLater((Plugin)Skyblock.getPlugin(), 10L);
                        }
                    }
                    for (int i = 0; i < 10; i++) {
                        PacketPlayOutWorldParticles packet;
                        loc.add(v);
                        loc.setY(loc.getY() + (50 - this.count) / 1000.0D);
                        packetx = null;
                        if (this.count % 2 == 0) {
                            packet = new PacketPlayOutWorldParticles(EnumParticle.REDSTONE, true, (float)loc.getX(), (float)loc.getY(), (float)loc.getZ(), 3.9215687E-5F, 0.0F, 0.0F, 1.0F, 0, new int[0]);
                        } else {
                            packet = new PacketPlayOutWorldParticles(EnumParticle.REDSTONE, true, (float)loc.getX(), (float)loc.getY(), (float)loc.getZ(), -0.9F, 0.2F, 0.2F, 1.0F, 0, new int[0]);
                        }
                        (((CraftPlayer)p).getHandle()).playerConnection.sendPacket((Packet)packet);
                        Iterator<Entity> var4 = p.getNearbyEntities(10.0D, 10.0D, 10.0D).iterator();
                        while (var4.hasNext()) {
                            Entity player = var4.next();
                            if (player instanceof Player)
                                (((CraftPlayer)player).getHandle()).playerConnection.sendPacket((Packet)packet);
                        }
                        this.count++;
                    }
                    if (this.count >= 100)
                        cancel();
                    if (world.getBlockAt((int)(loc.getX() - 0.5D), loc.getBlockY(), (int)(loc.getZ() - 0.5D)).getType() != Material.AIR)
                        cancel();
                }
            }).runTaskTimer((Plugin)Skyblock.getPlugin(), 1L, 1L);
            (new BukkitRunnable() {
                public void run() {
                    SoulWhip.cd.remove(p.getUniqueId());
                }
            }).runTaskLater((Plugin) Skyblock.getPlugin(), 10L);
        }
    }

    public int getManaCost() {
        return 0;
    }

    public String getDisplayName() {
        return "Soul Whip";
    }

    public int getBaseDamage() {
        return 145;
    }

    public double getBaseStrength() {
        return 175.0D;
    }

    public boolean displayUsage() {
        return false;
    }

    public String getAbilityReq() {
        return "&cYou do not have requirement to use this item!\n&cYou need at least &525 Sadan Kills &cto use it!";
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
}
