// 
// Decompiled by Procyon v0.5.36
// 

package me.godspunky.skyblock.features.entity.dungeon.bosses;

import com.google.common.util.concurrent.AtomicDouble;
import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.entity.EnumWatcherType;
import me.godspunky.skyblock.features.entity.HeadsOnWall;
import me.godspunky.skyblock.features.entity.SEntity;
import me.godspunky.skyblock.features.entity.SEntityEquipment;
import me.godspunky.skyblock.features.entity.zombie.BaseZombie;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.EntityManager;
import me.godspunky.skyblock.util.SSU;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.Sputnik;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.PacketPlayOutAnimation;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftZombie;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

public class WatcherBonzo extends BaseZombie {
    private ArmorStand tb;
    private boolean barrCD;
    private final String[] bozoCringe;

    public WatcherBonzo() {
        this.barrCD = true;
        this.bozoCringe = new String[]{"Cringe.", "Lame.", "Why are you running?", "Leave me alone!", "Oh noes! You got me! Whatever will I do?", "OUCH!", "Stop.", "Hacker!"};
    }

    @Override
    public String getEntityName() {
        return Sputnik.trans("&4&lMaster Bonzo");
    }

    @Override
    public double getEntityMaxHealth() {
        return 9.0E8;
    }

    @Override
    public double getDamageDealt() {
        return 5800000.0;
    }

    @Override
    public void onSpawn(LivingEntity entity, SEntity sEntity) {
        HeadsOnWall h = new HeadsOnWall(EnumWatcherType.BONZO);
        PlayerDisguise p = Sputnik.applyPacketNPC(entity, h.value, h.signature, true);
        EntityManager.DEFENSE_PERCENTAGE.put(entity, 85);
        entity.setMetadata("SlayerBoss", new FixedMetadataValue(Skyblock.getPlugin(), true));
        entity.setMetadata("LD", new FixedMetadataValue(Skyblock.getPlugin(), true));
        entity.setMetadata("WATCHER_E", new FixedMetadataValue(Skyblock.getPlugin(), true));
        p.setReplaceSounds(true);
        this.tb = Sputnik.spawnDialougeBox(entity, 2.2);
        this.sd("I'm back baby!", 10, 50, true);
        SUtil.delay(() -> this.barrCD = false, 250L);
        new BukkitRunnable() {
            public void run() {
                if (entity.isDead()) {
                    WatcherBonzo.this.sd("Bruh, just you wait...", 0, 40, true);
                    this.cancel();
                    return;
                }
                if (!WatcherBonzo.this.barrCD && SUtil.random(0, 30) <= 5 && ((CraftZombie) entity).getTarget() != null) {
                    WatcherBonzo.this.barrCD = true;
                    WatcherBonzo.this.ballonBarrage(entity);
                    SUtil.delay(() -> WatcherBonzo.this.barrCD = false, 300L);
                }
            }
        }.runTaskTimer(Skyblock.getPlugin(), 0L, 1L);
        new BukkitRunnable() {
            public void run() {
                if (entity.isDead()) {
                    this.cancel();
                    return;
                }
                if (((CraftZombie) entity).getTarget() != null) {
                    WatcherBonzo.this.sd(WatcherBonzo.this.bozoCringe[SUtil.random(0, WatcherBonzo.this.bozoCringe.length - 1)], 1, 50, true);
                }
            }
        }.runTaskTimer(Skyblock.getPlugin(), 80L, 80L);
        new BukkitRunnable() {
            public void run() {
                EntityLiving nms = ((CraftLivingEntity) entity).getHandle();
                if (entity.isDead()) {
                    this.cancel();
                    return;
                }
                for (Entity entities : entity.getWorld().getNearbyEntities(entity.getLocation().add(entity.getLocation().getDirection().multiply(1.0)), 1.5, 1.5, 1.5)) {
                    if (!(entities instanceof Player)) {
                        continue;
                    }
                    Player target = (Player) entities;
                    if (target.getGameMode() == GameMode.CREATIVE) {
                        continue;
                    }
                    if (target.getGameMode() == GameMode.SPECTATOR) {
                        continue;
                    }
                    if (target.hasMetadata("NPC")) {
                        continue;
                    }
                    if (target.getNoDamageTicks() == 7) {
                        continue;
                    }
                    if (SUtil.random(0, 10) > 8) {
                        continue;
                    }
                    entity.teleport(entity.getLocation().setDirection(target.getLocation().subtract(entities.getLocation()).toVector()));
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        ((CraftPlayer) players).getHandle().playerConnection.sendPacket(new PacketPlayOutAnimation(((CraftLivingEntity) entity).getHandle(), 0));
                    }
                    nms.r(((CraftPlayer) target).getHandle());
                    break;
                }
            }
        }.runTaskTimer(Skyblock.getPlugin(), 0L, 3L);
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SItem.of(SMaterial.BONZO_STAFF).getStack(), null, null, null, null);
    }

    @Override
    public void onDamage(SEntity sEntity, Entity damager, EntityDamageByEntityEvent e, AtomicDouble damage) {
        Entity en = sEntity.getEntity();
        Vector v = new Vector(0, 0, 0);
        SUtil.delay(() -> en.setVelocity(v), 1L);
    }

    public void say(String str) {
        if (str == null) {
            this.tb.setCustomNameVisible(false);
            return;
        }
        for (Player p : this.tb.getWorld().getPlayers()) {
            p.sendMessage(Sputnik.trans("&c[BOSS] Bonzo&f: " + str));
        }
        this.tb.setCustomNameVisible(true);
        this.tb.setCustomName(Sputnik.trans("&f&l" + str));
    }

    public void sd(String str, int delay, int timeout, boolean needTo) {
        SUtil.delay(() -> this.say(str), delay);
        if (needTo) {
            SUtil.delay(() -> {
                if (this.tb.getCustomName().contains(str)) {
                    this.say(null);
                }
            }, timeout + delay);
        }
    }

    public void ballonBarrage(LivingEntity e) {
        this.sd("SHOOOOOOWWWWWWWW TIMEEEEEEEEEEEE!!!", 1, 50, true);
        new BukkitRunnable() {
            int i = 0;

            public void run() {
                if (e.isDead() || this.i >= 100) {
                    e.removePotionEffect(PotionEffectType.SLOW);
                    this.cancel();
                    return;
                }
                ++this.i;
                e.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000, 10));
                Location lc = e.getLocation();
                lc.setYaw(lc.getYaw() + SUtil.random(0, 360));
                ((CraftZombie) e).getHandle().setPositionRotation(lc.getX(), lc.getY(), lc.getZ(), lc.getYaw(), lc.getPitch());
                WatcherBonzo.sendHeadRotation(e, lc.getYaw(), lc.getPitch());
                WatcherBonzo.this.launchBaloon(e);
            }
        }.runTaskTimer(Skyblock.getPlugin(), 0L, 2L);
    }

    public static void sendHeadRotation(Entity e, float yaw, float pitch) {
        net.minecraft.server.v1_8_R3.Entity pl = ((CraftZombie) e).getHandle();
        pl.setLocation(e.getLocation().getX(), e.getLocation().getY(), e.getLocation().getZ(), yaw, pitch);
        PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport(pl);
        for (Player p : e.getWorld().getPlayers()) {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        }
    }

    public void launchBaloon(LivingEntity player1) {
        player1.getWorld().playSound(player1.getLocation(), Sound.GHAST_MOAN, 1.0f, 2.0f);
        Location location = player1.getLocation().add(0.0, -0.5, 0.0);
        Vector vecTo = location.getDirection().normalize().multiply(1);
        Location location2 = player1.getLocation();
        Random random = new Random();
        int i = random.nextInt(9);
        Color color = Color.RED;
        ArmorStand stand = (ArmorStand) player1.getWorld().spawn(location.add(player1.getLocation().getDirection().multiply(1)), (Class) ArmorStand.class);
        stand.setVisible(false);
        stand.setGravity(false);
        stand.setMarker(true);
        stand.teleport(player1.getEyeLocation().add(vecTo));
        if (i == 1) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_1).getStack());
            color = Color.RED;
        }
        if (i == 2) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_2).getStack());
            color = Color.ORANGE;
        }
        if (i == 3) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_3).getStack());
            color = Color.YELLOW;
        }
        if (i == 4) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_4).getStack());
            color = Color.PURPLE;
        }
        if (i == 5) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_5).getStack());
            color = Color.BLUE;
        }
        if (i == 6) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_6).getStack());
            color = Color.AQUA;
        }
        if (i == 7) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_7).getStack());
            color = Color.LIME;
        }
        if (i == 8) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_8).getStack());
            color = Color.FUCHSIA;
        }
        if (i == 9) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_9).getStack());
            color = Color.GREEN;
        }
        Color color2 = color;
        Vector direction = location2.getDirection();
        new BukkitRunnable() {
            double t = 0.0;
            int tick = 0;

            public void run() {
                this.t += 1.0995574287564276;
                ++this.tick;
                float yaw = location.getYaw() + 10.0f;
                if (yaw >= 180.0f) {
                    yaw *= -1.0f;
                }
                location.setYaw(yaw);
                double x = direction.getX() * this.t;
                double y = direction.getY() * this.t;
                double z = direction.getZ() * this.t;
                location.add(x, y, z);
                stand.teleport(location);
                location.subtract(x, y, z);
                if (this.t >= 50.0) {
                    this.cancel();
                    stand.remove();
                }
                Location locof = stand.getLocation();
                locof.setY(locof.getY() + 1.0);
                if (locof.getBlock().getType() != Material.AIR) {
                    stand.remove();
                    FireworkEffect.Builder builder = FireworkEffect.builder();
                    FireworkEffect effect = builder.flicker(false).trail(false).with(FireworkEffect.Type.BURST).withColor(color2).build();
                    SSU.spawn(stand.getLocation(), effect);
                    this.cancel();
                }
                for (Entity en : stand.getNearbyEntities(1.0, 1.0, 1.0)) {
                    if (en instanceof Player) {
                        Player p = (Player) en;
                        p.getWorld().playSound(p.getLocation(), Sound.ITEM_BREAK, 1.0f, 1.0f);
                        User.getUser(p.getUniqueId()).damage(p.getMaxHealth() * 30.0 / 100.0, EntityDamageEvent.DamageCause.ENTITY_ATTACK, player1);
                        p.sendMessage(Sputnik.trans("&4&lMaster Bonzo&7's Balloon hit you for &c" + SUtil.commaify(p.getMaxHealth() * 20.0 / 100.0) + " &7damage."));
                        p.damage(1.0E-5);
                        p.setVelocity(player1.getLocation().toVector().subtract(p.getLocation().toVector()).normalize().multiply(-1.0).multiply(1.5));
                        FireworkEffect.Builder builder2 = FireworkEffect.builder();
                        FireworkEffect effect2 = builder2.flicker(false).trail(false).with(FireworkEffect.Type.BURST).withColor(color2).build();
                        SSU.spawn(stand.getLocation(), effect2);
                        stand.remove();
                        this.cancel();
                        break;
                    }
                }
            }
        }.runTaskTimer(Skyblock.getPlugin(), 0L, 1L);
    }

    @Override
    public void onAttack(EntityDamageByEntityEvent e) {
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    public boolean hasNameTag() {
        return false;
    }

    @Override
    public boolean isVillager() {
        return false;
    }

    @Override
    public double getXPDropped() {
        return 155.0;
    }

    @Override
    public double getMovementSpeed() {
        return 0.4;
    }
}
