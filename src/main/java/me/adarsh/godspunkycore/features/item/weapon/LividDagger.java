package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.listener.PlayerListener;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.FerocityCalculation;
import me.adarsh.godspunkycore.util.Groups;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.Sputnik;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutAnimation;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LividDagger implements ToolStatistics, MaterialFunction, Ability {
    public int getBaseDamage() {
        return 210;
    }

    public double getBaseStrength() {
        return 60.0D;
    }

    public double getBaseCritChance() {
        return 1.0D;
    }

    public double getBaseAttackSpeed() {
        return 100.0D;
    }

    public double getBaseCritDamage() {
        return 0.5D;
    }

    public String getDisplayName() {
        return "Livid Dagger";
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
        return null;
    }

    public String getAbilityName() {
        return "Throw";
    }

    public String getAbilityDescription() {
        return "Throw your dagger at your enemies! Your Critical Hits deal " + ChatColor.BLUE + "100% " + ChatColor.GRAY + "more damage if you are behind your target.";
    }

    String ACT3 = "true";

    private boolean active;

    @Override
    public void onAbilityUse(final Player player1, final SItem sItem) {
        final Location throwLoc = player1.getLocation().add(0.0, 1.2, 0.0);
        final Vector throwVec = player1.getLocation().add(player1.getLocation().getDirection().multiply(10)).toVector().subtract(player1.getLocation().toVector()).normalize().multiply(1.2);
        for (final Player p : player1.getWorld().getPlayers()) {
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)new PacketPlayOutAnimation((Entity)((CraftLivingEntity)player1).getHandle(), 0));
        }
        final ArmorStand armorStand1 = (ArmorStand)player1.getWorld().spawnEntity(throwLoc, EntityType.ARMOR_STAND);
        armorStand1.getEquipment().setItemInHand(SItem.of(SMaterial.IRON_SWORD).getStack());
        armorStand1.setGravity(false);
        armorStand1.setVisible(false);
        final Player bukkitPlayer = player1.getPlayer();
        final Vector teleportTo = bukkitPlayer.getLocation().getDirection().normalize().multiply(1);
        final Vector[] previousVector = { throwVec };
        new BukkitRunnable() {
            private int run = -1;

            public void run() {
                final int i;
                final int ran = i = 0;
                final int num = 90;
                final Location loc = null;
                ++this.run;
                if (this.run > 100) {
                    this.cancel();
                    return;
                }
                for (int j = 0; j < 7; ++j) {
                    armorStand1.getWorld().spigot().playEffect(armorStand1.getLocation().clone().add(0.0, 1.75, 0.0), Effect.CRIT, 0, 1, (float)SUtil.random(-0.5, 0.5), (float)SUtil.random(0.0, 0.5), (float)SUtil.random(-0.5, 0.5), 0.0f, 1, 100);
                }
                if (!armorStand1.getLocation().getBlock().getType().isTransparent() || armorStand1.isOnGround()) {
                    armorStand1.remove();
                    this.cancel();
                    return;
                }
                final double xPos = armorStand1.getRightArmPose().getX();
                armorStand1.setRightArmPose(new EulerAngle(xPos + 0.35, 0.0, 0.0));
                final Vector newVector = new Vector(throwVec.getX(), previousVector[0].getY() - 0.03, throwVec.getZ());
                previousVector[0] = newVector;
                armorStand1.setVelocity(newVector);
                if (i < 13) {
                    final int angle = i * 20 + num;
                    final boolean back = false;
                }
                else {
                    final int angle = i * 20 - num;
                    final boolean back = true;
                }
                if (!armorStand1.getLocation().getBlock().getType().isTransparent()) {
                    armorStand1.remove();
                    this.cancel();
                    return;
                }
                if (i % 2 == 0 && i < 13) {
                    armorStand1.teleport(armorStand1.getLocation().add(teleportTo).multiply(1.0));
                }
                else if (i % 2 == 0) {
                    armorStand1.teleport(armorStand1.getLocation().subtract(loc.getDirection().normalize().multiply(1)));
                }
                for (final org.bukkit.entity.Entity e : armorStand1.getNearbyEntities(0.7, 0.7, 0.7)) {
                    if (e instanceof LivingEntity && e != player1.getPlayer()) {
                        final Damageable entity = (Damageable)e;
                        if (entity.isDead()) {
                            continue;
                        }
                        if (!(entity instanceof LivingEntity)) {
                            continue;
                        }
                        if (entity instanceof Player || entity instanceof EnderDragonPart || entity instanceof Villager || entity instanceof ArmorStand || entity instanceof Item) {
                            continue;
                        }
                        if (entity instanceof ItemFrame) {
                            continue;
                        }
                        if (entity.hasMetadata("GiantSword")) {
                            continue;
                        }

                        final User user = User.getUser(player1.getUniqueId());
                        final Object[] atp = Sputnik.calculateDamage(player1, player1, sItem.getStack(), (LivingEntity)entity, false);
                        final double finalDamage1 = (float)atp[0];
                        FerocityCalculation.activeFerocityTimes(player1, (LivingEntity)entity, (int)finalDamage1, (boolean)atp[1]);
                        user.damageEntity((LivingEntity) entity, finalDamage1);
                        player1.playSound(player1.getLocation(), Sound.ITEM_BREAK, 1.0f, 1.0f);
                        player1.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7Your Livid Dagger hit &c1 &7enemy for &c" + SUtil.commaify(new BigDecimal(finalDamage1).setScale(1, RoundingMode.HALF_EVEN).doubleValue()) + " &7damage."));
                        this.cancel();
                        armorStand1.remove();
                        break;
                    }
                }
            }
        }.runTaskTimer((Plugin)Skyblock.getPlugin(), 1L, 1L);
        new BukkitRunnable() {
            public void run() {
                armorStand1.remove();
                this.cancel();
            }
        }.runTaskLater((Plugin)Skyblock.getPlugin(), 100L);
    }

    public int getAbilityCooldownTicks() {
        return 100;
    }

    public int getManaCost() {
        return 150;
    }
}
