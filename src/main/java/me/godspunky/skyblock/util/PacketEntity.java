package me.godspunky.skyblock.util;

import me.godspunky.skyblock.Skyblock;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class PacketEntity {
    Entity entity;
    List<Player> players;
    Packet spawn;
    List<Packet> spawnPackets;
    BukkitTask tickTask;
    String permission;
    static int showRadius = 50;
    public static List<PacketEntity> managers;
    double x;
    double y;
    double z;

    public PacketEntity(Entity e) {
        this.entity = e;
        this.players = new ArrayList<Player>();
        this.updateSpawnPacket();
        PacketEntity.managers.add(this);
        this.tickTask = Bukkit.getScheduler().runTaskTimer(Skyblock.getPlugin(), () -> this.tick(), 1L, 5L);
    }

    public void setShowPermission(String permission) {
        this.permission = permission;
    }

    public void addSpawnPacket(Packet packet) {
        if (this.spawnPackets == null) {
            this.spawnPackets = new ArrayList<Packet>();
        }
        this.spawnPackets.add(packet);
        this.sendCustomPacket(packet);
    }

    public void removeSpawnPacket(Packet packet) {
        this.spawnPackets.remove(packet);
    }

    public boolean updateLocation() {
        if (this.players.isEmpty()) {
            return false;
        }
        if (this.x == this.entity.locX && this.y == this.entity.locY && this.z == this.entity.locZ) {
            return true;
        }
        this.x = this.entity.locX;
        this.y = this.entity.locY;
        this.z = this.entity.locZ;
        PacketPlayOutEntityTeleport teleport = new PacketPlayOutEntityTeleport(this.entity);
        for (int i = 0; i < this.players.size(); ++i) {
            Player next = this.players.get(i);
            ((CraftPlayer) next).getHandle().playerConnection.sendPacket(teleport);
        }
        return true;
    }

    public boolean playAnimation(int anim) {
        if (this.players.isEmpty()) {
            return false;
        }
        PacketPlayOutAnimation teleport = new PacketPlayOutAnimation(this.entity, anim);
        for (int i = 0; i < this.players.size(); ++i) {
            Player next = this.players.get(i);
            ((CraftPlayer) next).getHandle().playerConnection.sendPacket(teleport);
        }
        return true;
    }

    public void tick() {
        List<Player> newPlayers = new ArrayList<Player>();
        this.updateSpawnPacket();
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getWorld().equals(this.entity.getBukkitEntity().getWorld()) && p.getLocation().distance(this.entity.getBukkitEntity().getLocation()) < 50.0) {
                if (this.players.contains(p)) {
                    this.players.remove(p);
                    newPlayers.add(p);
                } else {
                    if (!this.sendSpawnPacket(p)) {
                        continue;
                    }
                    newPlayers.add(p);
                }
            }
        }
        for (Player p : this.players) {
            this.sendDestroyPacket(p);
        }
        this.players = newPlayers;
    }

    public void destroy() {
        this.hide();
        this.tickTask.cancel();
        PacketEntity.managers.remove(this);
    }

    public void hide() {
        for (int i = 0; i < this.players.size(); ++i) {
            Player next = this.players.get(i);
            this.sendDestroyPacket(next);
        }
    }

    protected void updateSpawnPacket() {
        this.spawn = new PacketPlayOutSpawnEntityLiving((EntityLiving) this.entity);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void spawn() {
        for (Player next : this.players) {
            this.sendSpawnPacket(next);
        }
    }

    public void sendCustomPacket(Packet packet) {
        for (Player p : this.players) {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        }
    }

    protected boolean sendSpawnPacket(Player player) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(this.spawn);
        if (this.spawnPackets != null) {
            for (Packet packet : this.spawnPackets) {
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
            }
        }
        return true;
    }

    protected void sendDestroyPacket(Player player) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(new int[]{this.entity.getId()}));
    }

    public static void removePlayer(Player player) {
        for (PacketEntity manager : PacketEntity.managers) {
            manager.players.remove(player);
        }
    }

    static {
        PacketEntity.managers = new ArrayList<PacketEntity>();
    }
}
