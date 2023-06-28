package me.adarsh.godspunkycore.listener;

import com.google.common.util.concurrent.AtomicDouble;
import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.enchantment.Enchantment;
import me.adarsh.godspunkycore.features.enchantment.EnchantmentType;
import me.adarsh.godspunkycore.features.entity.SEntity;
import me.adarsh.godspunkycore.features.entity.SEntityType;
import me.adarsh.godspunkycore.features.islands.IslandManager;
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
import org.bukkit.event.player.*;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import me.adarsh.godspunkycore.SkyblockPlayer;

import java.io.IOException;
import java.util.*;

import static org.bukkit.Material.*;

public class PlayerListener extends PListener {
    private static final Map<UUID, BowShooting> BOW_MAP = new HashMap<>();
    private static final Map<UUID, CombatAction> COMBAT_MAP = new HashMap<>();

    private static final Map<UUID, User> USER_CACHE = new HashMap<>();
    private UUID uuid;
    private final Skyblock plugin;

    public PlayerListener(Skyblock skyblock) {
        this.plugin = skyblock;
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
        } else if (bottom.getBlock().getType().equals(ENDER_PORTAL)) {
            player.performCommand("sb warp home");
        } else if (to.getBlock().getType().equals(PORTAL)) {
            player.performCommand("sb warp hub");
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
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        User user = User.getUser(player.getUniqueId());
        if (!PlayerUtils.STATISTICS_CACHE.containsKey(player.getUniqueId()))
            PlayerUtils.STATISTICS_CACHE.put(player.getUniqueId(), PlayerUtils.getStatistics(player));
        for (Skill skill : Skill.getSkills())
            skill.onSkillUpdate(user, user.getSkillXP(skill));
        try {


            for (Chunk c : player.getWorld().getLoadedChunks()) {
                Bukkit.getPluginManager().callEvent(new ChunkLoadEvent(c, false));
            }


            if (Bukkit.getWorld(IslandManager.ISLAND_PREFIX + player.getUniqueId()) == null) {
                Bukkit.createWorld(new WorldCreator(IslandManager.ISLAND_PREFIX + player.getUniqueId()).type(WorldType.FLAT).generator(new ChunkGenerator() {
                    @Override
                    public byte[] generate(World world, Random random, int x, int z) {
                        return new byte[32768];
                    }
                }));
            }
        } catch (Exception e) {
            System.out.println("not able to load minions");
        }
    }

    @EventHandler
    public void createIsland(PlayerJoinEvent event) throws IOException {
        event.setJoinMessage(null);
        IslandManager.createIsland(event.getPlayer());
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


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) throws Exception {
        if (event.getClickedInventory() == null || event.getCurrentItem() == null || event.getCurrentItem().getType().equals(Material.AIR)) return;

        if (!event.getClickedInventory().getTitle().startsWith("Visit ")) return;

        event.setCancelled(true);

        if (event.getCurrentItem().getType().equals(Material.BARRIER)) event.getWhoClicked().closeInventory();
        else if (event.getCurrentItem().getType().equals(Material.SKULL_ITEM)) {
            event.getWhoClicked().closeInventory();

            String name = ChatColor.stripColor(event.getView().getTitle().replace("Visit ", ""));

            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(name);

            event.getWhoClicked().teleport(new Location(IslandManager.getIsland(offlinePlayer.getUniqueId()), 0, 100, 0));
        }
    }
}






