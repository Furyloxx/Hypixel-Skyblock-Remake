package me.godspunky.skyblock.features.slayer;

import com.google.common.util.concurrent.AtomicDouble;
import lombok.Getter;
import lombok.Setter;
import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.entity.SEntity;
import me.godspunky.skyblock.features.entity.SEntityType;
import me.godspunky.skyblock.sequence.SoundSequenceType;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.*;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

@Getter
public class SlayerQuest implements ConfigurationSerializable {
    private final SlayerBossType type;
    private final long started;
    @Setter
    private double xp;
    @Setter
    private long spawned;
    @Setter
    private long killed;
    @Setter
    private long died;
    @Setter
    private SEntityType lastKilled;
    @Setter
    private SEntity entity;
    private boolean bossSpawned;
    @Setter
    private Player owner;

    public SlayerQuest(SlayerBossType type, long started, Player owner) {
        this.type = type;
        this.started = started;
        this.entity = null;
        this.bossSpawned = false;
        this.owner = owner;
    }
            

    private SlayerQuest(SlayerBossType type, long started, double xp, long spawned, long killed, long died, SEntityType lastKilled, Player owner) {
        this.type = type;
        this.started = started;
        this.xp = xp;
        this.spawned = spawned;
        this.killed = killed;
        this.died = died;
        this.lastKilled = lastKilled;
        this.entity = null;
        this.bossSpawned = false;
        this.owner = owner;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type.getNamespace());
        map.put("started", started);
        map.put("xp", xp);
        map.put("spawned", spawned);
        map.put("killed", killed);
        map.put("died", died);
        map.put("lastKilled", lastKilled.name());
        map.put("owner", owner.getUniqueId().toString());
        return map;
    }

    public static SlayerQuest deserialize(Map<String, Object> map) {
        return new SlayerQuest(
            SlayerBossType.getByNamespace(String.valueOf(map.get("type"))),
            ((Number) map.get("started")).longValue(),
            ((Number) map.get("xp")).doubleValue(),
            ((Number) map.get("spawned")).longValue(),
            ((Number) map.get("killed")).longValue(),
            ((Number) map.get("died")).longValue(),
            SEntityType.valueOf(String.valueOf(map.get("lastKilled"))),
            Bukkit.getPlayer(UUID.fromString((String) map.get("owner")))
        );
    }

    public void addXP(double amount) {
        this.xp += amount;
        double progress = (this.xp / this.type.getSpawnXP()) * 100;
        owner.sendMessage(ChatColor.YELLOW + "Slayer XP: " + ChatColor.WHITE + SUtil.roundTo(this.xp, 1) + "/" + this.type.getSpawnXP() + " (" + SUtil.roundTo(progress, 1) + "%)");
        
        if (this.xp >= this.type.getSpawnXP() && !bossSpawned) {
            spawnBoss();
        }
    }

    private void spawnBoss() {
        bossSpawned = true;
        spawned = System.currentTimeMillis();
        Location spawnLoc = owner.getLocation();
        
        // TODO: Implement custom entity spawning logic here
        // This would involve creating a custom entity with the boss's attributes
        // entity = SEntityType.spawn(type.getSpecType(), spawnLoc);
        
        playBossSpawn(spawnLoc, owner);
        owner.sendMessage(ChatColor.RED + "The " + type.getDisplayName() + " has spawned!");
    }

    public void complete() {
        killed = System.currentTimeMillis();
 

 spawn effect for minibosses, similar to Hypixel's flashy visuals
    public static void playMinibossSpawn(Location location, Entity sound) {
        Location clone = location.clone();
        World world = location.getWorld();
        if (sound != null)
            SoundSequenceType.SLAYER_MINIBOSS_SPAWN.play(sound);
        else
            SoundSequenceType.SLAYER_MINIBOSS_SPAWN.play(clone);

        AtomicDouble height = new AtomicDouble();
        SUtil.runIntervalForTicks(() ->
                        world.spigot().playEffect(clone.clone().add(0.0, height.getAndAdd(0.5), 0.0), Effect.EXPLOSION_LARGE, 1, 0, 0.0f, 0.0f, 0.0f, 0.0f, 1, 16),
                3, 12
        );
    }

    // Plays the boss spawn effect with magical particles and explosions
    public static void playBossSpawn(Location location, Entity sound) {
        Location clone = location.clone();
        World world = location.getWorld();
        if (sound != null)
            SoundSequenceType.SLAYER_BOSS_SPAWN.play(sound);
        else
            SoundSequenceType.SLAYER_BOSS_SPAWN.play(clone);

        SUtil.runIntervalForTicks(() -> {
            for (int i = 0; i < 50; i++) {
                world.spawnParticle(Particle.SPELL_WITCH, clone, 1, 0.5, 0.5, 0.5, 0);
                world.spawnParticle(Particle.ENCHANTMENT_TABLE, clone, 1, 0.5, 0.5, 0.5, 0);
                world.spawnParticle(Particle.DRAGON_BREATH, clone, 1, 0.5, 0.5, 0.5, 0);
            }
        }, 5, 28);

        new BukkitRunnable() {
            public void run() {
                world.spawnParticle(Particle.EXPLOSION_HUGE, clone, 1, 0, 0, 0, 0);
                world.playSound(clone, Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
            }
        }.runTaskLater(Skyblock.getPlugin(), 28);
    }
}
