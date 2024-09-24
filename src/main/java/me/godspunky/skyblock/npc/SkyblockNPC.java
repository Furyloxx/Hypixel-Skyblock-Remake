package me.godspunky.skyblock.npc;

import me.godspunky.skyblock.util.SUtil;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import lombok.Getter;
import me.godspunky.skyblock.Skyblock;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.scoreboard.CraftScoreboard;
import org.bukkit.craftbukkit.v1_8_R3.scoreboard.CraftScoreboardManager;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

@Getter
public class SkyblockNPC {

    private final Set<UUID> viewers = new HashSet<>();
    private final List<EntityArmorStand> holograms = new ArrayList<>();

    private final UUID uuid;
    private final String name;
    private final World world;
    private final Location location;
    private final String texture;
    private final String signature;
    private final EntityPlayer entityPlayer;
    private final GameProfile gameProfile;
    private final NPCParameters parameters;

    public SkyblockNPC(NPCParameters npc) {
        this.uuid = UUID.randomUUID();
        this.name = npc.getName();
        this.world = Bukkit.getWorld(npc.getWorld());
        if (world == null) {
            throw new NullPointerException("World cannot be null for npc : " + name);
        }
        this.location = new Location(world, npc.getX(), npc.getY(), npc.getZ(), npc.getYaw(), npc.getPitch());
        this.texture = npc.getTexture();
        this.signature = npc.getSignature();
        MinecraftServer minecraftServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer worldServer = ((CraftWorld) location.getWorld()).getHandle();
        this.gameProfile = new GameProfile(uuid, name);
        // skin
        if (texture != null && signature != null) {
            gameProfile.getProperties().put(
                    "textures",
                    new Property("textures",
                            texture,
                            signature
                    )
            );
        }
        PlayerInteractManager interactManager = new PlayerInteractManager(worldServer);
        this.entityPlayer = new EntityPlayer(
                minecraftServer,
                worldServer,
                gameProfile,
                interactManager
        );
        entityPlayer.setLocation(
                location.getX(),
                location.getY(),
                location.getZ(),
                location.getYaw(),
                location.getPitch()
        );
        this.parameters = npc;
        SkyblockNPCManager.registerNPC(this);
    }

    public void showTo(Player player) {
        if (viewers.contains(player.getUniqueId())) return;
        PacketPlayOutPlayerInfo packetPlayOutPlayerInfo = new PacketPlayOutPlayerInfo(
                PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER,
                entityPlayer
        );
        PacketPlayOutNamedEntitySpawn packetPlayOutNamedEntitySpawn = new PacketPlayOutNamedEntitySpawn(
                entityPlayer
        );
        sendPacket(player, packetPlayOutPlayerInfo);
        sendPacket(player, packetPlayOutNamedEntitySpawn);

        CraftScoreboardManager scoreboardManager = ((CraftServer) Bukkit.getServer()).getScoreboardManager();
        CraftScoreboard craftScoreboard = scoreboardManager.getMainScoreboard();
        Scoreboard scoreboard = craftScoreboard.getHandle();

        ScoreboardTeam scoreboardTeam = scoreboard.getTeam(name);
        if (scoreboardTeam == null) {
            scoreboardTeam = new ScoreboardTeam(scoreboard, name);
        }
        scoreboardTeam.setNameTagVisibility(ScoreboardTeamBase.EnumNameTagVisibility.NEVER);
        scoreboardTeam.setPrefix("[NPC] ");

        sendPacket(player, new PacketPlayOutScoreboardTeam(scoreboardTeam, 1));
        sendPacket(player, new PacketPlayOutScoreboardTeam(scoreboardTeam, 0));
        sendPacket(player, new PacketPlayOutScoreboardTeam(scoreboardTeam, Collections.singletonList(name), 3));
        sendHologram(player, getParameters().getHolograms());
        this.viewers.add(player.getUniqueId());
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline() || !viewers.contains(player.getUniqueId())) {
                    cancel();
                    return;
                }
                if (isPlayerNearby(player)) {
                    sendHeadRotationPacket(player);
                }
            }
        }.runTaskTimer(Skyblock.getPlugin(), 0, 2);
    }

    public void hideFrom(Player player) {
        if (!viewers.contains(player.getUniqueId())) return;
        viewers.remove(player.getUniqueId());
        PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(entityPlayer.getId());
        sendPacket(player, packet);
        removeHolograms(player);
    }

    public void sendHeadRotationPacket(Player player) {
        Location original = getLocation();
        Location location = original.clone().setDirection(player.getLocation().subtract(original.clone()).toVector());

        byte yaw = (byte) (location.getYaw() * 256 / 360);
        byte pitch = (byte) (location.getPitch() * 256 / 360);

        PacketPlayOutEntityHeadRotation headRotationPacket = new PacketPlayOutEntityHeadRotation(
                this.entityPlayer,
                yaw
        );
        sendPacket(player, headRotationPacket);

        PacketPlayOutEntity.PacketPlayOutEntityLook lookPacket = new PacketPlayOutEntity.PacketPlayOutEntityLook(
                getId(),
                yaw,
                pitch,
                false
        );
        sendPacket(player, lookPacket);
    }

    private int getId() {
        return entityPlayer.getId();
    }

    public int getEntityID() {
        return entityPlayer.getBukkitEntity().getEntityId();
    }

    public boolean isPlayerNearby(Player player) {
        if (player == null) return false;
        Location npcLocation = getLocation();
        Location playerLocation = player.getLocation();

        if (!playerLocation.getWorld().equals(npcLocation.getWorld())) {
            return false;
        }
        double hideDistance = 25;
        double bukkitRange = Bukkit.getViewDistance() << 4;
        double distanceSquared = npcLocation.distanceSquared(playerLocation);

        return distanceSquared <= SUtil.square(hideDistance) && distanceSquared <= SUtil.square(bukkitRange);
    }

    public boolean isShown(Player player) {
        return viewers.contains(player.getUniqueId());
    }

    public static void sendPacket(Player player, Packet<?> packet) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

    public void sendHologram(Player player, String[] lines) {
        double yOffset = 0.0;
        double DELTA = 0.3;

        for (String text : lines) {
            EntityArmorStand armorStand = new EntityArmorStand(((CraftPlayer) player).getHandle().getWorld());
            Location hologramLocation = getLocation().clone().add(0, yOffset, 0);
            armorStand.setLocation(hologramLocation.getX(), hologramLocation.getY(), hologramLocation.getZ(), 0, 0);
            armorStand.setCustomName(ChatColor.translateAlternateColorCodes('&', text));
            armorStand.setCustomNameVisible(true);
            armorStand.setInvisible(true);
            armorStand.setGravity(false); // Fix for NPC not appearing in the specified place

            PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(armorStand);
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);

            holograms.add(armorStand);
            yOffset -= DELTA;
        }
    }

    public void removeHolograms(Player player) {
        for (EntityArmorStand armorStand : holograms) {
            PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(armorStand.getId());
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
        }
        holograms.clear();
    }

    public Location getLocation() {
        return this.location;
    }
}
