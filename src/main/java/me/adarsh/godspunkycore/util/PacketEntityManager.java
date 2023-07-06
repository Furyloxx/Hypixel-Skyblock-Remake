package me.adarsh.godspunkycore.util;

import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.Bukkit;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport;
import net.minecraft.server.v1_8_R3.EntityLiving;
import java.util.ArrayList;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import org.bukkit.entity.Player;
import java.util.List;
import net.minecraft.server.v1_8_R3.Entity;

public class PacketEntityManager
{
    Entity entity;
    List<Player> players;
    PacketPlayOutEntityDestroy destroy;
    PacketPlayOutSpawnEntityLiving spawn;
    
    public PacketEntityManager(final Entity e) {
        this.entity = e;
        this.players = new ArrayList<Player>();
        this.destroy = new PacketPlayOutEntityDestroy(new int[] { this.entity.getId() });
        this.spawn = new PacketPlayOutSpawnEntityLiving((EntityLiving)this.entity);
    }
    
    public boolean updateLocation() {
        final List<Player> newPlayers = new ArrayList<Player>();
        final PacketPlayOutEntityTeleport teleport = new PacketPlayOutEntityTeleport(this.entity);
        this.spawn = new PacketPlayOutSpawnEntityLiving((EntityLiving)this.entity);
        for (final Player p : Bukkit.getOnlinePlayers()) {
            if (p.getWorld().equals(this.entity.getBukkitEntity().getWorld()) && p.getLocation().distance(this.entity.getBukkitEntity().getLocation()) < 50.0) {
                newPlayers.add(p);
                if (this.players.contains(p)) {
                    this.players.remove(p);
                }
                else {
                    ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)this.spawn);
                }
                ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)teleport);
            }
        }
        for (final Player p : this.players) {
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)this.destroy);
        }
        if (newPlayers.isEmpty()) {
            return false;
        }
        this.players = newPlayers;
        return true;
    }
    
    public void destroy() {
        for (final Player p : this.players) {
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)this.destroy);
        }
    }
    
    public List<Player> getPlayers() {
        return this.players;
    }
    
    public void spawn() {
        for (final Player p : Bukkit.getOnlinePlayers()) {
            if (p.getWorld().equals(this.entity.getBukkitEntity().getWorld()) && p.getLocation().distance(this.entity.getBukkitEntity().getLocation()) < 50.0) {
                ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)this.spawn);
            }
        }
    }
    
    public void sendCustomPacket(final Packet packet) {
        for (final Player p : this.players) {
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
        }
    }
}
