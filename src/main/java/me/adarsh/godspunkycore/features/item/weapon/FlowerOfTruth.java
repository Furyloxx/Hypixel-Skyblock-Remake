package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.Repeater;
import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.listener.PlayerListener;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class FlowerOfTruth implements ToolStatistics, MaterialFunction, Ability {
    Vector teleportTo;

    public int getBaseDamage() {
        return 100;
    }

    public double getBaseStrength() {
        return 360.0D;
    }

    public String getDisplayName() {
        return "Flower of Truth";
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
        return "Heat-Seeking Rose";
    }

    public String getAbilityDescription() {
        return "Shoots a rose that ricochets between enemies, damaging up to " + ChatColor.GREEN + "3 " + ChatColor.GRAY + "of your foes! Damage multiplies as more enemies are hit. Cost " + ChatColor.GREEN + "10.0% " + ChatColor.GRAY + "of your maximum mana";
    }

    String ACT3 = "true";

    public void onAbilityUse(final Player player1, final SItem sItem) {
        int manaPool = SUtil.blackMagic(((PlayerStatistics)PlayerUtils.STATISTICS_CACHE.get(player1.getUniqueId())).getIntelligence().addAll().doubleValue() + 100.0D);
        int manaCost = manaPool * 10 / 100;
        final int cost = PlayerUtils.getFinalManaCost(player1, sItem, manaCost);
        boolean take = PlayerUtils.takeMana(player1, cost);
        if (!take) {
            player1.playSound(player1.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, -4.0F);
            final long c = System.currentTimeMillis();
            Repeater.MANA_REPLACEMENT_MAP.put(player1.getUniqueId(), new ManaReplacement() {
                public String getReplacement() {
                    return "" + ChatColor.RED + ChatColor.BOLD + "NOT ENOUGH MANA";
                }

                public long getEnd() {
                    return c + 1500L;
                }
            });
            return;
        }
        final long c = System.currentTimeMillis();
        Repeater.DEFENSE_REPLACEMENT_MAP.put(player1.getUniqueId(), new DefenseReplacement() {
            public String getReplacement() {
                return ChatColor.AQUA + "-" + cost + " Mana (" + ChatColor.GOLD + FlowerOfTruth.this.getAbilityName() + ChatColor.AQUA + ")";
            }

            public long getEnd() {
                return c + 2000L;
            }
        });
        Location throwLoc = player1.getLocation().add(0.0D, 0.2D, 0.0D);
        player1.playSound(player1.getLocation(), Sound.EAT, 1.0F, 1.0F);
        final ArmorStand armorStand1 = (ArmorStand)player1.getWorld().spawnEntity(throwLoc, EntityType.ARMOR_STAND);
        armorStand1.getEquipment().setHelmet(SItem.of(SMaterial.RED_ROSE).getStack());
        armorStand1.setHeadPose(new EulerAngle(-92.55000305175781D, 0.0D, 0.0D));
        armorStand1.setGravity(false);
        armorStand1.setVisible(false);
        Player bukkitPlayer = player1.getPlayer();
        this.teleportTo = bukkitPlayer.getLocation().getDirection().normalize().multiply(1);
        final List<LivingEntity> le = new ArrayList<>();
        (new BukkitRunnable() {
            private int run = -1;

            int entityhit = 0;

            public void run() {
                Vector teleportTo = armorStand1.getLocation().getDirection().normalize().multiply(1);
                int ran = 0;
                int i = ran;
                int j = 0;
                int num = 90;
                Location loc = null;
                this.run++;
                j++;
                if (this.run > 100) {
                    cancel();
                    return;
                }
                if (j >= 40) {
                    armorStand1.remove();
                    cancel();
                    return;
                }
                Location locof = armorStand1.getLocation();
                locof.setY(locof.getY() + 1.0D);
                if (locof.getBlock().getType() != Material.AIR) {
                    armorStand1.getWorld().playEffect(locof, Effect.SNOWBALL_BREAK, 3);
                    armorStand1.getWorld().playEffect(locof, Effect.SNOWBALL_BREAK, 10);
                    armorStand1.getWorld().playEffect(locof, Effect.SNOWBALL_BREAK, 10);
                    armorStand1.getWorld().playEffect(locof, Effect.SNOWBALL_BREAK, 10);
                    armorStand1.remove();
                    cancel();
                    return;
                }
                if (this.entityhit >= 3 || le.size() >= 3) {
                    armorStand1.getWorld().playEffect(locof, Effect.SNOWBALL_BREAK, 3);
                    armorStand1.getWorld().playEffect(locof, Effect.SNOWBALL_BREAK, 10);
                    armorStand1.getWorld().playEffect(locof, Effect.SNOWBALL_BREAK, 10);
                    armorStand1.getWorld().playEffect(locof, Effect.SNOWBALL_BREAK, 10);
                    armorStand1.remove();
                    cancel();
                    return;
                }
                if (this.entityhit < 3)
                    for (Entity e2 : armorStand1.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
                        if (e2 instanceof LivingEntity) {
                            if (e2.isDead() == true ||
                                    !(e2 instanceof LivingEntity) ||
                                    e2 instanceof Player || e2 instanceof org.bukkit.entity.EnderDragonPart || e2 instanceof org.bukkit.entity.Villager || e2 instanceof ArmorStand || e2 instanceof org.bukkit.entity.Item || e2 instanceof org.bukkit.entity.ItemFrame ||
                                    e2.hasMetadata("GiantSword"))
                                continue;
                            armorStand1.teleport(armorStand1.getLocation().setDirection(e2.getLocation().toVector().subtract(armorStand1.getLocation().toVector())));
                            break;
                        }
                    }
                if (i % 2 == 0 && i < 13) {
                    armorStand1.teleport(armorStand1.getLocation().add(teleportTo).multiply(1.0D));
                } else if (i % 2 == 0) {
                    armorStand1.teleport(armorStand1.getLocation().subtract(loc.getDirection().normalize().multiply(1)));
                }
                for (Entity e : armorStand1.getNearbyEntities(1.0D, 1.0D, 1.0D)) {
                    if (e instanceof LivingEntity && e != player1.getPlayer()) {
                        Damageable entity = (Damageable)e;
                        if (le.contains(e) ||
                                entity.isDead() == true ||
                                !(entity instanceof LivingEntity) ||
                                entity instanceof Player || entity instanceof org.bukkit.entity.EnderDragonPart || entity instanceof org.bukkit.entity.Villager || entity instanceof ArmorStand || entity instanceof org.bukkit.entity.Item || entity instanceof org.bukkit.entity.ItemFrame ||
                                entity.hasMetadata("GiantSword"))
                            continue;
                        User user = User.getUser(player1.getUniqueId());
                        Object[] atp = Sputnik.calculateDamage(player1, player1, sItem.getStack(), (LivingEntity)entity, false);
                        double finalDamage1 = ((Float)atp[0]).floatValue();
                        le.add((LivingEntity)e);
                        FerocityCalculation.activeFerocityTimes(player1, (LivingEntity)entity, (int)finalDamage1, ((Boolean)atp[1]).booleanValue());
                        user.damageEntity((LivingEntity) entity, finalDamage1);
                        this.entityhit++;
                        int k = 0;
                        for (Entity e2 : armorStand1.getNearbyEntities(20.0D, 20.0D, 20.0D)) {
                            if (e2 instanceof LivingEntity) {
                                if (e2.isDead() == true ||
                                        !(e2 instanceof LivingEntity) ||
                                        e2 instanceof Player || e2 instanceof org.bukkit.entity.EnderDragonPart || e2 instanceof org.bukkit.entity.Villager || e2 instanceof ArmorStand || e2 instanceof org.bukkit.entity.Item || e2 instanceof org.bukkit.entity.ItemFrame ||
                                        e2.hasMetadata("GiantSword"))
                                    continue;
                                k++;
                            }
                        }
                        if (k <= 0) {
                            armorStand1.getWorld().playEffect(armorStand1.getLocation().clone().add(0.0D, 1.8D, 0.0D), Effect.SNOWBALL_BREAK, 10);
                            armorStand1.getWorld().playEffect(armorStand1.getLocation().clone().add(0.0D, 1.8D, 0.0D), Effect.SNOWBALL_BREAK, 10);
                            armorStand1.getWorld().playEffect(armorStand1.getLocation().clone().add(0.0D, 1.8D, 0.0D), Effect.SNOWBALL_BREAK, 10);
                            armorStand1.getWorld().playEffect(armorStand1.getLocation().clone().add(0.0D, 1.8D, 0.0D), Effect.SNOWBALL_BREAK, 10);
                            armorStand1.remove();
                            cancel();
                        }
                    }
                }
            }
        }).runTaskTimer((Plugin)Skyblock.getPlugin(), 1L, 1L);
        (new BukkitRunnable() {
            public void run() {
                if (armorStand1.isDead())
                    return;
                armorStand1.getWorld().playEffect(armorStand1.getLocation().clone().add(0.0D, 1.8D, 0.0D), Effect.SNOWBALL_BREAK, 10);
                armorStand1.getWorld().playEffect(armorStand1.getLocation().clone().add(0.0D, 1.8D, 0.0D), Effect.SNOWBALL_BREAK, 10);
                armorStand1.getWorld().playEffect(armorStand1.getLocation().clone().add(0.0D, 1.8D, 0.0D), Effect.SNOWBALL_BREAK, 10);
                armorStand1.getWorld().playEffect(armorStand1.getLocation().clone().add(0.0D, 1.8D, 0.0D), Effect.SNOWBALL_BREAK, 10);
                armorStand1.remove();
                cancel();
            }
        }).runTaskLater((Plugin)Skyblock.getPlugin(), 40L);
    }

    public int getAbilityCooldownTicks() {
        return 20;
    }

    public int getManaCost() {
        return 0;
    }

    public boolean isEnchanted() {
        return true;
    }
}

