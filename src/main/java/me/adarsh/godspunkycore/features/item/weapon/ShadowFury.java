package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.user.User;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutAnimation;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class ShadowFury implements ToolStatistics, MaterialFunction, Ability {
    public int getBaseDamage() {
        return 310;
    }

    public double getBaseStrength() {
        return 130.0D;
    }

    public double getBaseSpeed() {
        return 0.3D;
    }

    public String getDisplayName() {
        return "Shadow Fury";
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
        return "";
    }

    public String getAbilityName() {
        return "Shadow Fury";
    }

    public String getAbilityDescription() {
        return "Rapidly teleports you to up to " + ChatColor.AQUA + "5 " + ChatColor.GRAY + "enemies within " + ChatColor.YELLOW + "12 " + ChatColor.GRAY + "blocks, rooting each of them and allowing you to hit them.";
    }

    public void onAbilityUse(final Player player, final SItem sItem) {
        int count1 = 0;
        List<org.bukkit.entity.Entity> inRange = player.getNearbyEntities(12.0D, 12.0D, 12.0D);
        final List<Entity> filteredList = new ArrayList<>();
        for (org.bukkit.entity.Entity e : inRange) {
            if (e instanceof Damageable && e != player)
                if (!(e instanceof org.bukkit.entity.ArmorStand) && !(e instanceof Player) && !e.hasMetadata("NPC") && !e.hasMetadata("GiantSword")) {
                    if (filteredList.size() < 5 && filteredList.size() >= 0) {
                        filteredList.add((Entity) e);
                        continue;
                    }
                    break;
                }
        }
        if (inRange.size() != 0) {
            (new BukkitRunnable() {
                private int run = 0;

                public void run() {
                    if (this.run < filteredList.size()) {
                        if (((Entity)filteredList.get(this.run)).isAlive()) {
                            player.teleport(((Entity)filteredList.get(this.run)).getBukkitEntity().getLocation().add(((Entity)filteredList.get(this.run)).getBukkitEntity().getLocation().getDirection().multiply(-1)));
                            player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 3.0F, 1.0F);
                            User user = User.getUser(player.getUniqueId());
                            Entity e = filteredList.get(this.run);
                            for (Player p : player.getWorld().getPlayers())
                                (((CraftPlayer)p).getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutAnimation((Entity)((CraftLivingEntity)player).getHandle(), 0));
                        }
                        this.run++;
                    } else {
                        cancel();
                    }
                }
            }).runTaskTimer((Plugin) Skyblock.getPlugin(), 1L, 5L);
        } else {
            player.sendMessage(ChatColor.RED + "No nearby target found.");
        }
    }

    public int getAbilityCooldownTicks() {
        return 50;
    }

    public int getManaCost() {
        return 0;
    }
}