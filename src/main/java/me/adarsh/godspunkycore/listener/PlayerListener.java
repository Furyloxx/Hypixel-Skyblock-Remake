package me.adarsh.godspunkycore.listener;

import com.google.common.util.concurrent.AtomicDouble;
import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.enchantment.Enchantment;
import me.adarsh.godspunkycore.features.enchantment.EnchantmentType;
import me.adarsh.godspunkycore.features.entity.SEntity;
import me.adarsh.godspunkycore.features.entity.SEntityType;
import me.adarsh.godspunkycore.features.item.SBlock;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.features.item.accessory.AccessoryFunction;
import me.adarsh.godspunkycore.features.item.bow.BowFunction;
import me.adarsh.godspunkycore.features.item.pet.Pet;
import me.adarsh.godspunkycore.features.item.pet.PetAbility;
import me.adarsh.godspunkycore.features.launchpads.LaunchPadHandler;
import me.adarsh.godspunkycore.features.potion.PotionEffect;
import me.adarsh.godspunkycore.features.skill.Skill;
import me.adarsh.godspunkycore.features.slayer.SlayerQuest;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftHumanEntity;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.bukkit.Material.SLIME_BLOCK;

public class PlayerListener extends PListener {
    private static final Map<UUID, BowShooting> BOW_MAP = new HashMap<>();
    private static final Map<UUID, CombatAction> COMBAT_MAP = new HashMap<>();

    private static final Map<UUID, User> USER_CACHE = new HashMap<>();
    private UUID uuid;
    private final Skyblock plugin;

    public PlayerListener(Skyblock skyblock) {
        this.plugin = skyblock;
    }

    public static void ferocityActive(final int times, final Player p, final double finalDMG, final Entity damaged, final Boolean crit) {
        if (times > 0) {
            p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 0.4f, 0.0f);
        }
        for (int i = 0; i < times; ++i) {
            final LivingEntity le = (LivingEntity)damaged;
            if (le.isDead()) {
                break;
            }
            if (le.isDead()) {
                return;
            }
            final User user = User.getUser(p.getUniqueId());
            new BukkitRunnable() {
                public void run() {
                    //
                    // This method could not be decompiled.
                    //
                    // Original Bytecode:
                    //
                    //     1: getfield        vn/giakhanhvn/skysim/listener/PlayerListener$4.val$damaged:Lorg/bukkit/entity/Entity;
                    //     4: invokeinterface org/bukkit/entity/Entity.isDead:()Z
                    //     9: ifeq            13
                    //    12: return
                    //    13: aload_0         /* this */
                    //    14: getfield        vn/giakhanhvn/skysim/listener/PlayerListener$4.val$p:Lorg/bukkit/entity/Player;
                    //    17: aload_0         /* this */
                    //    18: getfield        vn/giakhanhvn/skysim/listener/PlayerListener$4.val$p:Lorg/bukkit/entity/Player;
                    //    21: invokeinterface org/bukkit/entity/Player.getLocation:()Lorg/bukkit/Location;
                    //    26: getstatic       org/bukkit/Sound.FIRE_IGNITE:Lorg/bukkit/Sound;
                    //    29: ldc             0.4
                    //    31: fconst_0
                    //    32: invokeinterface org/bukkit/entity/Player.playSound:(Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
                    //    37: aload_0         /* this */
                    //    38: getfield        vn/giakhanhvn/skysim/listener/PlayerListener$4.val$damaged:Lorg/bukkit/entity/Entity;
                    //    41: aload_0         /* this */
                    //    42: getfield        vn/giakhanhvn/skysim/listener/PlayerListener$4.val$finalDMG:D
                    //    45: aload_0         /* this */
                    //    46: getfield        vn/giakhanhvn/skysim/listener/PlayerListener$4.val$p:Lorg/bukkit/entity/Player;
                    //    49: aload_0         /* this */
                    //    50: getfield        vn/giakhanhvn/skysim/listener/PlayerListener$4.val$crit:Ljava/lang/Boolean;
                    //    53: aload_0         /* this */
                    //    54: getfield        vn/giakhanhvn/skysim/listener/PlayerListener$4.val$user:Lvn/giakhanhvn/skysim/user/User;
                    //    57: invokedynamic   BootstrapMethod #0, run:(Lorg/bukkit/entity/Entity;DLorg/bukkit/entity/Player;Ljava/lang/Boolean;Lvn/giakhanhvn/skysim/user/User;)Ljava/lang/Runnable;
                    //    62: ldc2_w          10
                    //    65: invokestatic    vn/giakhanhvn/skysim/util/SUtil.delay:(Ljava/lang/Runnable;J)V
                    //    68: return
                    //    StackMapTable: 00 01 0D
                    //
                    // The error that occurred was:
                    //
                    // java.lang.IllegalStateException: Could not infer any expression.
                    //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:374)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
                    //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
                    //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:425)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
                    //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
                    //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
                    //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
                    //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
                    //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
                    //
                    throw new IllegalStateException("An error occurred while decompiling this method.");
                }
            }.runTaskLater((Plugin)Skyblock.getPlugin(), (long)(4 * i));
        }
    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Location to = e.getTo();
        Location bottom = new Location(to.getWorld(), to.getX(), to.getY() - 1, to.getZ());
        Player player = e.getPlayer();
        if (bottom.getBlock().getType().equals(SLIME_BLOCK)) {
            LaunchPadHandler padHandler = plugin.getLaunchPadHandler();
            String pad = padHandler.closeTo(player);
            if (!pad.equals("NONE")) {
                padHandler.launch(player, pad);
            }
        }

        SBlock block = SBlock.getBlock(player.getLocation().clone().subtract(0, 0.3, 0));
        if ((player.getGameMode() != GameMode.CREATIVE && player.getGameMode() != GameMode.SPECTATOR) && e.getTo().getY() <= -20.0)
            User.getUser(player.getUniqueId()).kill(EntityDamageEvent.DamageCause.VOID, null);
        if (block == null) return;
        if (block.getType() == SMaterial.BOUNCER) {
            player.setVelocity(player.getVelocity().setY(block.getDataFloat("bounce")));
            new BukkitRunnable() {
                public void run() {
                    player.setVelocity(new Vector(block.getDataFloat("velX"), block.getDataFloat("velY"), block.getDataFloat("velZ")));
                }
            }.runTaskLater(Skyblock.getPlugin(), block.getDataLong("delay"));
        }
        if (block.getType() != SMaterial.LAUNCHER && block.getType() != SMaterial.TELEPORTER_LAUNCHER) return;
        SEntity stand = new SEntity(player.getLocation(), SEntityType.VELOCITY_ARMOR_STAND);
        ArmorStand s = ((ArmorStand) stand.getEntity());
        s.setPassenger(player);
        s.setGravity(true);
        s.setVisible(false);
        new BukkitRunnable() {
            public void run() // if the launch is longer than 10 seconds, boot off the passenger
            {
                s.eject();
                s.remove();
            }
        }.runTaskLater(Skyblock.getPlugin(), 200);
        stand.getEntity().setVelocity(new Vector(block.getDataFloat("velX"), block.getDataFloat("velY"), block.getDataFloat("velZ")));
        if (block.getType() == SMaterial.TELEPORTER_LAUNCHER) {
            new BukkitRunnable() {
                public void run() {
                    player.setFallDistance(0.0f);
                    player.teleport(new Location(Bukkit.getWorld(block.getDataString("world")),
                            block.getDataDouble("x"),
                            block.getDataDouble("y"),
                            block.getDataDouble("z"),
                            block.getDataFloat("yaw"),
                            block.getDataFloat("pitch")));
                }
            }.runTaskLater(Skyblock.getPlugin(), block.getDataLong("delay"));
        }
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        User user = User.getUser(player.getUniqueId());
        if (!PlayerUtils.STATISTICS_CACHE.containsKey(player.getUniqueId()))
            PlayerUtils.STATISTICS_CACHE.put(player.getUniqueId(), PlayerUtils.getStatistics(player));
        for (Skill skill : Skill.getSkills())
            skill.onSkillUpdate(user, user.getSkillXP(skill));
        player.sendMessage(SUtil.getRandomVisibleColor() + "" + ChatColor.BOLD + "[GodSpunky] : Sending to island , Please wait");
      PlayerUtils.sendToIsland(player);
      // not need delay anymore as island is already loaded at startup
    }


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        User user = User.getUser(player.getUniqueId());
        SlayerQuest quest = user.getSlayerQuest();
        if (quest != null && quest.getSpawned() != 0 && (quest.getKilled() != 0 || quest.getDied() != 0)) {
            if (quest.getEntity() != null)
                quest.getEntity().remove();
            quest.setDied(System.currentTimeMillis());
        }
        user.save();
    }

    @EventHandler
    public void onPlayerDeath(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        if (e instanceof EntityDamageByEntityEvent)
            return;
        Player player = (Player) e.getEntity();
        User user = User.getUser(player.getUniqueId());
        if ((player.getHealth() + ((CraftHumanEntity) player).getHandle().getAbsorptionHearts()) - e.getDamage() <= 0.0) {
            e.setCancelled(true);
            user.kill(e.getCause(), null);
            return;
        }
        user.damage(e.getDamage(), e.getCause(), null);
        e.setDamage(0.0);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        Entity damaged = e.getEntity();
        if (damaged instanceof ArmorStand) {
            e.setCancelled(true);
            return;
        }
        Entity damager = e.getDamager();
        if (damaged instanceof LivingEntity && damager instanceof FishHook && damager.hasMetadata("owner")) {
            User.getUser(((Player) damager.getMetadata("owner").get(0).value()).getUniqueId()).damageEntity((LivingEntity) damaged);
            return;
        }
        SEntity sEntity = null;
        if (!(damager instanceof Player)) {
            Entity in = damager;
            if (in instanceof Arrow) {
                Arrow arrow = (Arrow) in;
                ProjectileSource shooter = arrow.getShooter();
                if (shooter instanceof Entity)
                    in = (Entity) shooter;
            }
            sEntity = SEntity.findSEntity(in);
            if (sEntity != null) {
                sEntity.getFunction().onAttack(e);
                e.setDamage(sEntity.getStatistics().getDamageDealt());
                try {
                    e.setDamage(EntityDamageEvent.DamageModifier.ARMOR, 0.0);
                } catch (UnsupportedOperationException ignored) {
                }
            }
        }

        if (damaged instanceof Player) {
            Player damagedPlayer = (Player) damaged;
            User user = User.getUser(damagedPlayer.getUniqueId());
            PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(damagedPlayer.getUniqueId());
            if (statistics == null) return;
            double defense = statistics.getDefense().addAll();
            double trueDefense = statistics.getTrueDefense().addAll();
            if (sEntity != null && sEntity.getStatistics().dealsTrueDamage())
                e.setDamage(e.getDamage() - (e.getDamage() * (trueDefense / (trueDefense + 100))));
            else
                e.setDamage(e.getDamage() - (e.getDamage() * (defense / (defense + 100))));
            EntityDamageEvent.DamageCause cause = e.getCause();
            if (damager instanceof Projectile && ((Projectile) damager).getShooter() instanceof Entity) {
                damager = (Entity) ((Projectile) damager).getShooter();
                cause = EntityDamageEvent.DamageCause.ENTITY_ATTACK;
            }
            if (damager instanceof Fireball) {
                SEntity fb = (SEntity) damager.getMetadata("dragon").get(0).value();
                int d = SUtil.random(292, 713);
                e.setDamage(d);
                damagedPlayer.sendMessage(ChatColor.DARK_PURPLE + "☬ " + ChatColor.RED + fb.getStatistics().getEntityName() +
                        ChatColor.LIGHT_PURPLE + " used " + ChatColor.YELLOW + "Fireball" +
                        ChatColor.LIGHT_PURPLE + " on you for " + ChatColor.RED + d +
                        " damage.");
                damager = fb.getEntity();
                cause = EntityDamageEvent.DamageCause.ENTITY_ATTACK;
            }
            Pet.PetItem item = user.getActivePet();
            Pet pet = user.getActivePetClass();
            if (item != null && pet != null) {
                for (PetAbility ability : pet.getPetAbilities(item.toItem()))
                    ability.onHurt(e, damager);
            }
            try {
                e.setDamage(EntityDamageEvent.DamageModifier.ARMOR, 0.0);
            } catch (UnsupportedOperationException ignored) {
            }
            if (damagedPlayer.getHealth() - e.getDamage() <= 0.0) {
                e.setCancelled(true);
                User.getUser(damagedPlayer.getUniqueId()).kill(cause, damager);
            }
            COMBAT_MAP.put(damagedPlayer.getUniqueId(), createCombatAction(false, e.getDamage(), e.getDamager() instanceof Arrow, System.currentTimeMillis()));
            return;
        }

        if (!(damager instanceof Player) && !(damager instanceof Arrow)) return;
        Player player;
        ItemStack weapon;
        float bowForceReducer = 1.0f;
        if (damager instanceof Arrow) {
            Arrow arrow = (Arrow) damager;
            ProjectileSource shooter = arrow.getShooter();
            if (!(shooter instanceof Player)) return;
            player = (Player) shooter;
            if (!BOW_MAP.containsKey(player.getUniqueId())) return;
            BowShooting shooting = BOW_MAP.get(player.getUniqueId());
            weapon = shooting.getBow();
            bowForceReducer = shooting.getForce();
            player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1f, 1f);
        } else {
            player = (Player) e.getDamager();
            weapon = player.getInventory().getItemInHand();
        }
        PlayerUtils.DamageResult result = PlayerUtils.getDamageDealt(weapon, player, damaged, damager instanceof Arrow);
        AtomicDouble finalDamage = new AtomicDouble(result.getFinalDamage() * bowForceReducer);
        e.setDamage(finalDamage.get());
        SItem sItem = SItem.find(weapon);
        if (sItem != null) {
            if (sItem.getType().getFunction() != null)
                sItem.getType().getFunction().onDamage(damaged, player, finalDamage, sItem);
            if (sItem.getType().getFunction() instanceof BowFunction && e.getDamager() instanceof Arrow)
                ((BowFunction) sItem.getType().getFunction()).onBowHit(damaged, player, (Arrow) e.getDamager(), sItem, finalDamage);
        }
        for (SItem accessory : PlayerUtils.getAccessories(player)) {
            if (accessory.getType().getFunction() instanceof AccessoryFunction)
                ((AccessoryFunction) accessory.getType().getFunction()).onDamageInInventory(sItem, player, damaged, accessory, finalDamage);
        }
        User user = User.getUser(player.getUniqueId());
        Pet pet = user.getActivePetClass();
        if (pet != null) pet.runAbilities((ability) -> ability.onDamage(e), user.getActivePet());
        try {
            e.setDamage(EntityDamageEvent.DamageModifier.ARMOR, 0.0);
        } catch (UnsupportedOperationException ignored) {
        }
        SEntity s = SEntity.findSEntity(damaged);
        if (s != null)
            s.getFunction().onDamage(s, damager, e, finalDamage);
        if (e.isCancelled())
            return;
        PlayerUtils.handleSpecEntity(damaged, player, finalDamage);

        COMBAT_MAP.put(player.getUniqueId(), createCombatAction(true, e.getDamage(), e.getDamager() instanceof Arrow, System.currentTimeMillis()));

        ArmorStand stand = (ArmorStand) new SEntity(damaged.getLocation().clone().add(SUtil.random(-1.5, 1.5), 2, SUtil.random(-1.5, 1.5)), SEntityType.UNCOLLIDABLE_ARMOR_STAND).getEntity();
        stand.setCustomName(result.didCritDamage() ?
                SUtil.rainbowize("✧" + ((int) e.getDamage()) + "✧") : "" + ChatColor.GRAY + (int) e.getDamage());
        stand.setCustomNameVisible(true);
        stand.setGravity(false);
        stand.setVisible(false);
        new BukkitRunnable() {
            public void run() {
                stand.remove();
            }
        }.runTaskLater(plugin, 30);
    }
    @EventHandler
    public void onBowShoot(EntityShootBowEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        BOW_MAP.put(e.getEntity().getUniqueId(), new BowShooting() {
            @Override
            public ItemStack getBow() {
                return e.getBow();
            }

            @Override
            public float getForce() {
                return e.getForce();
            }
        });
        User user = User.getUser(e.getEntity().getUniqueId());
        Player player = (Player) e.getEntity();
        SItem arrows = SItem.find(player.getInventory().getItem(8));
        if (arrows != null && arrows.getType() == SMaterial.QUIVER_ARROW) {
            int save = arrows.getStack().getAmount();
            new BukkitRunnable() {
                public void run() {
                    ItemStack last = player.getInventory().getItem(8);
                    if (last == null) {
                        user.subFromQuiver(SMaterial.ARROW);
                        player.getInventory().setItem(8, SItem.of(SMaterial.SKYBLOCK_MENU).getStack());
                        return;
                    }
                    if (save == last.getAmount()) return;
                    user.subFromQuiver(SMaterial.ARROW);
                    player.getInventory().setItem(8, SUtil.setStackAmount(SItem.of(SMaterial.QUIVER_ARROW).getStack(), Math.min(64, user.getQuiver(SMaterial.ARROW))));
                }
            }.runTaskLater(Skyblock.getPlugin(), 1);
        }
        SItem sItem = SItem.find(e.getBow());
        if (sItem != null) {
            Enchantment aiming = sItem.getEnchantment(EnchantmentType.AIMING);
            SUtil.markAimingArrow((Projectile) e.getProjectile(), aiming);
            if (sItem.getType().getFunction() instanceof BowFunction)
                ((BowFunction) sItem.getType().getFunction()).onBowShoot(sItem, e);
        }
    }

    @EventHandler
    public void onArmorStandChange(PlayerArmorStandManipulateEvent e) {
        if (e.getRightClicked().hasMetadata("specUnbreakableArmorStand"))
            e.setCancelled(true);
    }

    @EventHandler
    public void onPotionDrink(PlayerItemConsumeEvent e) {
        SItem sItem = SItem.find(e.getItem());
        if (sItem == null) return;
        if (sItem.getType() != SMaterial.WATER_BOTTLE) return;
        e.setCancelled(true);
        List<PotionEffect> effects = sItem.getPotionEffects();
        User user = User.getUser(e.getPlayer().getUniqueId());
        for (PotionEffect effect : effects) {
            user.removePotionEffect(effect.getType());
            PlayerUtils.updatePotionEffects(user, PlayerUtils.STATISTICS_CACHE.get(user.getUuid()));
            if (effect.getType().getOnDrink() != null)
                effect.getType().getOnDrink().accept(effect, e.getPlayer());
            user.addPotionEffect(effect);
            e.getPlayer().sendMessage((effect.getType().isBuff() ? ChatColor.GREEN + "" + ChatColor.BOLD + "BUFF!" :
                    ChatColor.RED + "" + ChatColor.BOLD + "DEBUFF!") +
                    ChatColor.RESET + ChatColor.WHITE + " You have gained " + effect.getDisplayName() + ChatColor.WHITE + "!");
        }
        if (e.getPlayer().getGameMode() != GameMode.CREATIVE && e.getPlayer().getGameMode() != GameMode.SPECTATOR)
            e.getPlayer().setItemInHand(SItem.of(SMaterial.GLASS_BOTTLE).getStack());
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow) {
            new BukkitRunnable() {
                public void run() {
                    e.getEntity().remove();
                }
            }.runTaskLater(Skyblock.getPlugin(), 10);
            return;
        }
        if (e.getEntity() instanceof Fireball && (e.getEntity().hasMetadata("dragon") || e.getEntity().hasMetadata("magma"))) {
            String type = e.getEntity().hasMetadata("dragon") ? "dragon" : "magma";
            SEntity sEntity = (SEntity) e.getEntity().getMetadata(type).get(0).value();
            e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.EXPLOSION_HUGE, Effect.EXPLOSION_HUGE.getData());
            e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.EXPLODE, 5f, 0f);
            for (Entity entity : e.getEntity().getNearbyEntities(2, 2, 2)) {
                if (!(entity instanceof LivingEntity)) continue;
                int d = type.equals("dragon") ? SUtil.random(292, 713) : 125;
                if (entity instanceof Player)
                    User.getUser(entity.getUniqueId()).damage(d, EntityDamageEvent.DamageCause.ENTITY_ATTACK, sEntity.getEntity());
                else
                    ((LivingEntity) entity).damage(d);
                if (type.equals("dragon")) {
                    entity.sendMessage(ChatColor.DARK_PURPLE + "☬ " + ChatColor.RED + sEntity.getStatistics().getEntityName() +
                            ChatColor.LIGHT_PURPLE + " used " + ChatColor.YELLOW + "Fireball" +
                            ChatColor.LIGHT_PURPLE + " on you for " + ChatColor.RED + d +
                            " damage.");
                }
            }
        }
    }

    public static CombatAction getLastCombatAction(Player player) {
        return COMBAT_MAP.get(player.getUniqueId());
    }

    private static CombatAction createCombatAction(boolean attacked, double damage, boolean bowShot, long timestamp) {
        return new CombatAction() {
            @Override
            public boolean attacked() {
                return attacked;
            }

            @Override
            public double getDamageDealt() {
                return damage;
            }

            @Override
            public boolean isBowShot() {
                return bowShot;
            }

            @Override
            public long getTimeStamp() {
                return timestamp;
            }
        };
    }

    public interface CombatAction {
        boolean attacked();

        double getDamageDealt();

        boolean isBowShot();

        long getTimeStamp();
    }

    private interface BowShooting {
        ItemStack getBow();

        float getForce();
    }

    public static org.bukkit.World getIsland(Player player) {
        return Bukkit.getWorld("island_" + player.getName());
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().contains("Visit")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType().equals(Material.SKULL_ITEM)) {
                String name = ChatColor.stripColor(e.getView().getTitle().replace("Visit ", ""));
                e.getWhoClicked().closeInventory();
                World targetworld = Bukkit.getWorld("islands");
                OfflinePlayer op = Bukkit.getOfflinePlayer(name);
                if (op.hasPlayedBefore()) {
                    UUID uuid = op.getUniqueId();
                    User user = User.getUser(uuid);
                    player.teleport(targetworld.getHighestBlockAt(SUtil.blackMagic(user.getIslandX()),
                            SUtil.blackMagic(user.getIslandZ())).getLocation().add(0.5, 1.0, 0.5));
                    player.sendMessage(ChatColor.GREEN + "" + "[GodSpunky] : " + "Visiting " + name + " island");
                }
            }
        }
    }
    @EventHandler
    public void onInvFull(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        Inventory inventory = player.getInventory();

        if (inventory.firstEmpty() == -1) {

            player.sendMessage(ChatColor.RED+"Your Inventory is full!");
            SUtil.sendTitle(player,ChatColor.RED+"Inventory full!");
            player.playSound(player.getLocation(),Sound.LEVEL_UP,1.0f,1.0f);
        }
    }
}






