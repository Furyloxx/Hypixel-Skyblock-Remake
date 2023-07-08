package me.adarsh.godspunkycore.listener;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.entity.SEntity;
import me.adarsh.godspunkycore.features.entity.SlimeStatistics;
import me.adarsh.godspunkycore.features.entity.caverns.CreeperFunction;
import me.adarsh.godspunkycore.features.entity.nms.Dragon;
import me.adarsh.godspunkycore.features.event.CreeperIgniteEvent;
import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.features.region.Region;
import me.adarsh.godspunkycore.features.region.RegionType;
import me.adarsh.godspunkycore.features.skill.FarmingSkill;
import me.adarsh.godspunkycore.features.skill.ForagingSkill;
import me.adarsh.godspunkycore.features.skill.MiningSkill;
import me.adarsh.godspunkycore.features.skill.Skill;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.Groups;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

public class WorldListener extends PListener {
    private static final Map<UUID, List<BlockState>> RESTORER = new HashMap<>();
    private static final List<UUID> ALREADY_TELEPORTING = new ArrayList<>();

    public static boolean allowBreak = false;

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        if (e.getSpawnReason() != CreatureSpawnEvent.SpawnReason.NATURAL) return;
        if (e.getEntity() instanceof FallingBlock) return;
        e.setCancelled(true);
    }

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent e) {
        if (e.getEntity().getType() == EntityType.ENDERMAN)
            e.setCancelled(true);
        if (e.getBlock().getType() == Material.SOIL && e.getTo() == Material.DIRT)
            e.setCancelled(true);
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        Entity entity = e.getEntity();
        if (entity instanceof EnderDragonPart || entity instanceof EnderDragon || entity instanceof Creeper)
            e.blockList().clear();
    }

    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent e) {
        if (e.getIgnitingEntity() instanceof Fireball)
            e.setCancelled(true);
    }

    @EventHandler
    public void onBlockFade(BlockFadeEvent e) {
        if (e.getNewState().getType() == Material.DIRT || e.getNewState().getType() == Material.GRASS)
            e.setCancelled(true);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        if (!entity.hasMetadata("specEntityObject")) return;
        e.getDrops().clear();
    }

    @EventHandler
    public void onCreeperIgnite(CreeperIgniteEvent e) {
        Creeper creeper = e.getEntity();
        SEntity sEntity = SEntity.findSEntity(creeper);
        if (sEntity == null) return;
        if (sEntity.getFunction() instanceof CreeperFunction)
            ((CreeperFunction) sEntity.getFunction()).onCreeperIgnite(e, sEntity);
    }

    @EventHandler
    public void onLeafDecay(LeavesDecayEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Block block = e.getBlock();
        Player player = e.getPlayer();
        User user = User.getUser(player.getUniqueId());
        SMaterial equiv = SMaterial.getSpecEquivalent(block.getType(), block.getData());
        Region region = Region.getRegionOfBlock(block);
        Collection<ItemStack> drops = block.getDrops(e.getPlayer().getItemInHand());

        if (region != null) {
            if (Groups.FORAGING_REGIONS.contains(region.getType())) {
                if (block.getType() == Material.LOG || block.getType() == Material.LOG_2 || block.getType() == Material.LEAVES ||
                        block.getType() == Material.LEAVES_2) {
                    allowBreak = true;
                    int level = Skill.getLevel(user.getSkillXP(ForagingSkill.INSTANCE), ForagingSkill.INSTANCE.hasSixtyLevels());
                    double d = ForagingSkill.INSTANCE.getDoubleDropChance(level);
                    double t = ForagingSkill.INSTANCE.getTripleDropChance(level);
                    extraDrops(drops, d, t, block);
                    addToRestorer(block, player);
                }
            }
            if (Groups.FARMING_REGIONS.contains(region.getType())) {
                if (Groups.FARMING_MATERIALS.contains(block.getType())) {
                    allowBreak = true;
                    int level = Skill.getLevel(user.getSkillXP(FarmingSkill.INSTANCE), FarmingSkill.INSTANCE.hasSixtyLevels());
                    double d = FarmingSkill.INSTANCE.getDoubleDropChance(level);
                    extraDrops(drops, d, 0.0, block);
                }
            }
            if (Groups.MINING_REGIONS.contains(region.getType())) {
                Material type = block.getType();
                switch (type) {
                    case COAL_ORE:
                    case DIAMOND_BLOCK:
                    case DIAMOND_ORE:
                    case EMERALD_ORE:
                    case GOLD_ORE:
                    case IRON_ORE:
                    case LAPIS_ORE:
                    case REDSTONE_ORE: {
                        block.setType(Material.STONE);
                        break;
                    }
                    case STONE: {
                        if (block.getData() != 0)
                            break;
                        block.setType(Material.COBBLESTONE);
                        break;
                    }
                    case OBSIDIAN:
                    case ENDER_STONE:
                    case NETHERRACK:
                    case COBBLESTONE: {
                        block.setType(Material.BEDROCK);
                        regenerateLater(block, 3 * 20, region.getType());
                        break;
                    }
                }
                if (type != block.getType()) {
                    e.setCancelled(true);
                    if (equiv.getStatistics() instanceof ExperienceRewardStatistics)
                        Skill.reward(((ExperienceRewardStatistics) equiv.getStatistics()).getRewardedSkill(), ((ExperienceRewardStatistics) equiv.getStatistics()).getRewardXP(), player);
                    int level = Skill.getLevel(user.getSkillXP(MiningSkill.INSTANCE), MiningSkill.INSTANCE.hasSixtyLevels());
                    double d = MiningSkill.INSTANCE.getDoubleDropChance(level);
                    double t = MiningSkill.INSTANCE.getTripleDropChance(level);
                    for (ItemStack drop : drops) {
                        SItem conv = SItem.convert(drop);
                        conv.setOrigin(ItemOrigin.NATURAL_BLOCK);
                        block.getWorld().dropItemNaturally(block.getLocation().clone().add(0.5, 0.5, 0.5),
                                conv.getStack());
                    }
                    extraDrops(drops, d, t, block);
                }
                if (block.getType() == Material.GLOWSTONE) {
                    allowBreak = true;
                    addToRestorer(block, player);
                }
            }
                /*World world = Bukkit.getWorld("islands");
                World hubworld = Bukkit.getWorld("Hypixel");
                double islandX = user.getIslandX();
                double islandZ = user.getIslandZ();
                Location loc1 = new Location(world, islandX, 100, islandZ);
                loc1.add(100, 100, 100);
                Location loc2 = new Location(world, islandX, 100, islandZ);
                loc2.subtract(100, 100, 100);
                Cuboid cuboid = new Cuboid(loc1, loc2);
                if (cuboid.contains(player.getLocation())) {
                    allowBreak = true;*/


            if (user.isOnIsland(block))
                allowBreak = true;

            if (!allowBreak)
                e.setCancelled(true);
        }


        if (equiv.getStatistics() instanceof ExperienceRewardStatistics && !e.isCancelled())
            Skill.reward(((ExperienceRewardStatistics) equiv.getStatistics()).getRewardedSkill(), ((ExperienceRewardStatistics) equiv.getStatistics()).getRewardXP(), player);
        SBlock sBlock = SBlock.getBlock(e.getBlock().getLocation());
        if (sBlock != null && !e.isCancelled())
            sBlock.delete();
        if (e.isCancelled() || player.getGameMode() == GameMode.CREATIVE)
            return;
        e.setCancelled(true);
        for (ItemStack drop : drops) {
            SItem conv = SItem.convert(drop);
            conv.setOrigin(ItemOrigin.NATURAL_BLOCK);
            block.getWorld().dropItemNaturally(block.getLocation().clone().add(0.5, 0.5, 0.5),
                    conv.getStack());
        }
        block.setType(Material.AIR);
    }

    @EventHandler
    public void onFarmlandDecay(BlockPhysicsEvent e) {
        if (e.getChangedType() == Material.SOIL)
            e.setCancelled(true);
    }

    @EventHandler
    public void onEntityTarget(EntityTargetLivingEntityEvent e) {
        Entity entity = e.getEntity();
        SEntity sEntity = SEntity.findSEntity(entity);
        if (sEntity == null) return;
        sEntity.getFunction().onTarget(sEntity, e);
        if (!(sEntity.getGenericInstance() instanceof Dragon)) return;
        e.setCancelled(true);
    }

    @EventHandler
    public void onPortalEnter(EntityPortalEnterEvent e) {
        Player player = (Player) e.getEntity();
        Region region = Region.getRegionOfEntity(player);

        if (player.getWorld().getName().contains("island")){
            int x = plugin.getConfig().getInt("hub.x");
            int y = plugin.getConfig().getInt("hub.y");
            int z = plugin.getConfig().getInt("hub.z");
            int yaw = plugin.getConfig().getInt("hub.yaw");
            int pitch = plugin.getConfig().getInt("hub.pitch");
            World hub = Bukkit.getWorld(plugin.getConfig().getString("hub.world"));
            player.sendMessage(ChatColor.GRAY + "Sending to hub...");
            player.teleport(new Location(hub, x, y, z, yaw, pitch));
        }

        if (region != null && region.getType().equals(RegionType.VILLAGE)){
            player.sendMessage(ChatColor.GRAY + "Sending to island...");
            PlayerUtils.sendToIsland(player);
        }
    }

    @EventHandler
    public void onPortal(PlayerPortalEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPortalCreate(EntityCreatePortalEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onSlimeSplit(SlimeSplitEvent e) {
        Slime slime = e.getEntity();
        SEntity sEntity = SEntity.findSEntity(slime);
        if (sEntity != null) {
            if (sEntity.getStatistics() instanceof SlimeStatistics && !((SlimeStatistics) sEntity.getStatistics()).split())
                e.setCancelled(true);
        }
    }

    private static void addToRestorer(Block block, Player player) {
        if (RESTORER.containsKey(player.getUniqueId()))
            RESTORER.get(player.getUniqueId()).add(block.getState());
        else {
            RESTORER.put(player.getUniqueId(), new ArrayList<>());
            RESTORER.get(player.getUniqueId()).add(block.getState());
            new BukkitRunnable() {
                public void run() {
                    for (BlockState state : RESTORER.get(player.getUniqueId())) {
                        state.getBlock().setType(state.getType());
                        state.setRawData(state.getRawData());
                        state.update();
                    }
                    RESTORER.remove(player.getUniqueId());
                }
            }.runTaskLater(Skyblock.getPlugin(), 60 * 20);
        }
    }

    private static void extraDrops(Collection<ItemStack> drops, double d, double t, Block block) {
        for (ItemStack drop : drops) {
            int amount = 0;
            if (SUtil.random(0.0, 1.0) < t)
                amount = 2;
            else if (SUtil.random(0.0, 1.0) < d)
                amount = 1;
            if (amount == 0)
                continue;
            block.getWorld().dropItemNaturally(block.getLocation().clone().add(0.5, 0.5, 0.5),
                    SUtil.setStackAmount(drop, amount));
        }
    }

    private static BukkitTask regenerateLater(Block block, long ticks, RegionType type) {
        return new BukkitRunnable() {
            public void run() {
                if (block.getType() != Material.BEDROCK)
                    return;
                int r5 = SUtil.random(1, 5);
                switch (type) {
                    case COAL_MINE: {
                        if (SUtil.random(1, 15) == 1) {
                            block.setType(Material.COAL_ORE);
                            break;
                        }
                        block.setType(Material.STONE);
                        break;
                    }
                    case GOLD_MINE:
                    case GUNPOWDER_MINES: {
                        if (SUtil.random(1, 20) == 1) {
                            block.setType(Material.GOLD_ORE);
                            break;
                        }
                        if (r5 == 1) {
                            block.setType(Material.IRON_ORE);
                            break;
                        }
                        block.setType(Material.STONE);
                        break;
                    }
                    case LAPIS_QUARRY: {
                        if (r5 == 1) {
                            block.setType(Material.LAPIS_ORE);
                            break;
                        }
                        block.setType(Material.STONE);
                        break;
                    }
                    case PIGMENS_DEN: {
                        if (r5 == 1) {
                            block.setType(Material.REDSTONE_ORE);
                            break;
                        }
                        block.setType(Material.STONE);
                        break;
                    }
                    case SLIMEHILL: {
                        if (r5 == 1) {
                            block.setType(Material.EMERALD_ORE);
                            break;
                        }
                        block.setType(Material.STONE);
                        break;
                    }
                    case DIAMOND_RESERVE: {
                        if (r5 == 1) {
                            block.setType(Material.DIAMOND_ORE);
                            break;
                        }
                        block.setType(Material.STONE);
                        break;
                    }
                    case OBSIDIAN_SANCTUARY: {
                        if (SUtil.random(1, 40) == 1) {
                            block.setType(Material.DIAMOND_BLOCK);
                            break;
                        }
                        if (SUtil.random(1, 30) == 1) {
                            block.setType(Material.OBSIDIAN);
                            break;
                        }
                        if (r5 == 1) {
                            block.setType(Material.DIAMOND_ORE);
                            break;
                        }
                        block.setType(Material.STONE);
                        break;
                    }
                    case THE_END:
                    case DRAGONS_NEST: {
                        block.setType(Material.ENDER_STONE);
                        break;
                    }
                    case BLAZING_FORTRESS: {
                        block.setType(Material.NETHERRACK);
                        break;
                    }
                    default: {
                        block.setType(Material.STONE);
                        break;
                    }
                }
            }
        }.runTaskLater(Skyblock.getPlugin(), ticks);
    }

}