package me.adarsh.godspunkycore.features.entity.dungeon;

import com.google.common.util.concurrent.AtomicDouble;
import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.entity.SEntity;
import me.adarsh.godspunkycore.features.entity.SEntityEquipment;
import me.adarsh.godspunkycore.features.entity.zombie.BaseZombie;
import me.adarsh.godspunkycore.features.entity.zombie.NPCMobs;
import me.adarsh.godspunkycore.util.EntityManager;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.Sputnik;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import net.minecraft.server.v1_8_R3.AttributeInstance;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.GenericAttributes;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutAnimation;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftZombie;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;

public class CryptDreadlord extends BaseZombie implements NPCMobs {
    private boolean skullShoot = false;

    private boolean skullShootCD = true;

    public String getEntityName() {
        return "Crypt Dreadlord";
    }

    public double getEntityMaxHealth() {
        return 1.0E8D;
    }

    public double getDamageDealt() {
        return 1500000.0D;
    }

    public static ItemStack b(int hexcolor, Material m) {
        ItemStack stack = SUtil.applyColorToLeatherArmor(new ItemStack(m), Color.fromRGB(hexcolor));
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.spigot().setUnbreakable(true);
        stack.setItemMeta(itemMeta);
        return stack;
    }

    public void onSpawn(final LivingEntity entity, SEntity sEntity) {
        SUtil.delay(() -> this.skullShootCD = false, 100L);
        ((CraftZombie)entity).setBaby(false);
        AttributeInstance followRange = ((CraftLivingEntity)entity).getHandle().getAttributeInstance(GenericAttributes.FOLLOW_RANGE);
        followRange.setValue(40.0D);
        final PlayerDisguise pl = Sputnik.applyPacketNPC((org.bukkit.entity.Entity) entity, "ewogICJ0aW1lc3RhbXAiIDogMTYyNjMyMjczMDkzMSwKICAicHJvZmlsZUlkIiA6ICIzZmM3ZmRmOTM5NjM0YzQxOTExOTliYTNmN2NjM2ZlZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJZZWxlaGEiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDA5M2Q2NTJjMWI5ZjIyZmUwZTgxZWIxYTAyOGZhNGIwYjY5MDRjZWQ1YzdlZTlkNjI5YTgxOTU2MDc2NDk5YyIKICAgIH0KICB9Cn0=", "NybQzjteIreKG8mUVlpy4+gVYEloMFxsdAQyfRk5+WS2braPgTWfwxVvv8sukxJLpgxQjrOzSOVhwW5k4cO9j2n8ugWUOzUWnrxGzKmvegZ5UTmDVanLhg2ESFce0oFadJ7RrrQeYYgfqFFjKsA/9Q+Aky0KfdV38pt8U2UsGq68IVSjyickXD3QiwHR9u4FINT98th6m4/9iwhm80Oz1wd9C3O4kdpqGwNWrxLJx8MlcTfzmqSnuuw8bpSNXjXeD1yuScqAXkr8CYg78vg106YFQMNMuwNyIJX65HtTnjJD01xjoKVDw+jKZkFy9v/9ejtQyUjv1cumzrD+lQDejbKyFDNq5cuS0FGza3cfZrqXDXLRr4ujxARNQGxDsbRaXHVbGhuVnHfKy2Z5SjjPOgAzk+ZLzt3nINsp0lRj9xxYilOnKLi+6ExC38+1xUwcU2jtqvkqqCHYDe35WtVIj6nir/sBSbOu93z2anM7/eFH2cboGP/JVwrAJ4o5gH2u644DTxfB9zd6uUqs2mKGwSDd6N/S8IYJmjjQbk87mj9NpnMvWbPVpAs7pmROzuLJ12w+wJtUz6LqU1Nr5YgZyT2NgGiG9xZl560RAAXtNDexM29Zy+gNfIL6aYuLoy6Jz0OhPcKmDfsVWsSsUO7AQDRSLcc5cgGO17m/P0E0l6o=", true);
        pl.getWatcher().setRightClicking(false);
        EntityManager.DEFENSE_PERCENTAGE.put(entity, Integer.valueOf(70));
        entity.setMetadata("LD", (MetadataValue)new FixedMetadataValue((Plugin)Skyblock.getPlugin(), Boolean.valueOf(true)));
        entity.setMetadata("DungeonMobs", (MetadataValue)new FixedMetadataValue((Plugin) Skyblock.getPlugin(), Boolean.valueOf(true)));
        entity.setMetadata("SlayerBoss", (MetadataValue)new FixedMetadataValue((Plugin)Skyblock.getPlugin(), Boolean.valueOf(true)));
        (new BukkitRunnable() {
            public void run() {
                if (entity.isDead()) {
                    cancel();
                    return;
                }
                if (((CraftZombie)entity).getTarget() != null) {
                    CryptDreadlord.this.skullShoot = true;
                    CryptDreadlord.this.throwSkull(entity, pl);
                    SUtil.delay(() -> CryptDreadlord.this.throwSkull(entity, pl), 20L);
                    SUtil.delay(() -> CryptDreadlord.this.throwSkull(entity, pl), 30L);
                    SUtil.delay(() -> CryptDreadlord.this.throwSkull(entity, pl), 40L);
                    SUtil.delay(() -> CryptDreadlord.this.throwSkull(entity, pl), 50L);
                    SUtil.delay(() -> CryptDreadlord.this.throwSkull(entity, pl), 60L);
                    SUtil.delay(() -> CryptDreadlord.this.throwSkull(entity, pl), 70L);
                    SUtil.delay(() -> CryptDreadlord.this.throwSkull(entity, pl), 80L);
                    SUtil.delay(() -> CryptDreadlord.this.throwSkull(entity, pl), 90L);
                    SUtil.delay(() -> CryptDreadlord.this.throwSkull(entity, pl), 100L);
                    SUtil.delay(() -> {
                        CryptDreadlord.this.throwSkull(entity, pl);
                        CryptDreadlord.this.skullShoot = false;
                    },100L);
                }
            }
        }).runTaskTimer((Plugin)Skyblock.getPlugin(), 40L, 200L);
        (new BukkitRunnable() {
            public void run() {
                EntityLiving nms = ((CraftLivingEntity)entity).getHandle();
                if (entity.isDead()) {
                    cancel();
                    return;
                }
                CraftLivingEntity craftLivingEntity = ((CraftZombie)entity).getTarget();
                for (org.bukkit.entity.Entity entities : entity.getWorld().getNearbyEntities(entity.getLocation().add(entity.getLocation().getDirection().multiply(1.0D)), 1.5D, 1.5D, 1.5D)) {
                    if (CryptDreadlord.this.skullShoot)
                        continue;
                    if (!(entities instanceof Player))
                        continue;
                    Player target = (Player)entities;
                    if (target.getGameMode() == GameMode.CREATIVE)
                        continue;
                    if (target.getGameMode() == GameMode.SPECTATOR)
                        continue;
                    if (target.hasMetadata("NPC"))
                        continue;
                    if (target.getNoDamageTicks() == 7)
                        continue;
                    if (SUtil.random(0, 10) > 8)
                        continue;
                    entity.teleport(entity.getLocation().setDirection(target.getLocation().subtract(entities.getLocation()).toVector()));
                    for (Player players : Bukkit.getOnlinePlayers())
                        (((CraftPlayer)players).getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutAnimation((Entity)((CraftLivingEntity)entity).getHandle(), 0));
                    nms.r((Entity)((CraftPlayer)target).getHandle());
                }
            }
        }).runTaskTimer((Plugin)Skyblock.getPlugin(), 0L, 2L);
    }

    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(new ItemStack(Material.DIAMOND_SWORD), null, null, null, null);
    }

    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {}

    public boolean isBaby() {
        return false;
    }

    public boolean hasNameTag() {
        return false;
    }

    public boolean isVillager() {
        return false;
    }

    public void onDamage(SEntity sEntity, Entity damager, EntityDamageByEntityEvent e, AtomicDouble damage) {}

    public double getXPDropped() {
        return 56.0D;
    }

    public double getMovementSpeed() {
        return 0.2D;
    }

    public void throwSkull(LivingEntity e, PlayerDisguise pl) {
        pl.getWatcher().setRightClicking(true);
        WitherSkull skull = (WitherSkull)e.launchProjectile(WitherSkull.class);
        skull.setShooter((ProjectileSource)e);
        e.getWorld().playSound(e.getLocation(), Sound.WITHER_SHOOT, 1.0F, 1.0F);
        SUtil.delay(() -> pl.getWatcher().setRightClicking(false), 10L);
    }
}
