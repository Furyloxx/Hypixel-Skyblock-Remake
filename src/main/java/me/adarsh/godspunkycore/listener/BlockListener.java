package me.adarsh.godspunkycore.listener;

import me.adarsh.godspunkycore.command.RegionCommand;
import me.adarsh.godspunkycore.features.region.Cuboid;
import me.adarsh.godspunkycore.features.region.Region;
import me.adarsh.godspunkycore.features.region.RegionGenerator;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockListener extends PListener {
    @EventHandler
    public void onBlockInteract(PlayerInteractEvent e) {
        Block block = e.getClickedBlock();
        if (block == null) return;
        Player player = e.getPlayer();
        if (!RegionCommand.REGION_GENERATION_MAP.containsKey(player)) return;
        e.setCancelled(true);
        RegionGenerator generator = RegionCommand.REGION_GENERATION_MAP.get(player);
        switch (generator.getPhase()) {
            case 1: {
                generator.setFirstLocation(block.getLocation());
                generator.setPhase(2);
                player.sendMessage(ChatColor.GRAY + "Set your clicked block as the first location of the region!");
                player.sendMessage(ChatColor.DARK_AQUA + "Click the second corner of your region.");
                break;
            }
            case 2: {
                generator.setSecondLocation(block.getLocation());
                if (generator.getModificationType().equals("create"))
                    Region.create(generator.getName(), generator.getFirstLocation(), generator.getSecondLocation(), generator.getType());
                else {
                    Region region = Region.get(generator.getName());
                    region.setFirstLocation(generator.getFirstLocation());
                    region.setSecondLocation(generator.getSecondLocation());
                    region.setType(generator.getType());
                    region.save();
                }
                player.sendMessage(ChatColor.GRAY + "Region \"" + generator.getName() + "\" has been fully set up and " + (generator.getModificationType()) + "d!");
                RegionCommand.REGION_GENERATION_MAP.remove(player);
                break;
            }
        }
    }

    @EventHandler
    public void BlockPlace(BlockPlaceEvent e) {
        Player players = e.getPlayer();
        User user = User.getUser(players.getUniqueId());
        World world = Bukkit.getWorld("islands");
        double islandX = user.getIslandX();
        double islandZ = user.getIslandZ();
        Location loc1 = new Location(world, islandX, 100, islandZ);
        loc1.add(100, 100, 100);
        Location loc2 = new Location(world, islandX, 100, islandZ);
        loc2.subtract(100, 100, 100);
        Cuboid cuboid = new Cuboid(loc1, loc2);
        if (cuboid.contains(players.getLocation())) {
            e.setCancelled(false);
        } else {
            players.sendMessage(SUtil.getRandomVisibleColor() + "" + ChatColor.BOLD + "[GodSpunky] : You cant Place block here");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void BlockBreak(BlockBreakEvent e) {
        Player players = e.getPlayer();
        User user = User.getUser(players.getUniqueId());
        World world = Bukkit.getWorld("islands");
        double islandX = user.getIslandX();
        double islandZ = user.getIslandZ();
        Location loc1 = new Location(world, islandX, 100, islandZ);
        loc1.add(100, 100, 100);
        Location loc2 = new Location(world, islandX, 100, islandZ);
        loc2.subtract(100, 100, 100);
        Cuboid cuboid = new Cuboid(loc1, loc2);
        if (cuboid.contains(players.getLocation()) || WorldListener.allowBreak) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }


   /* @EventHandler
    public void BlockBreak(BlockBreakEvent e) {

        boolean allowbreak = false;
        Player players = e.getPlayer();
        User user = User.getUser(players.getUniqueId());
        World world = Bukkit.getWorld("islands");
        World hubworld = Bukkit.getWorld("Hypixel");
        double islandX = user.getIslandX();
        double islandZ = user.getIslandZ();
        Location loc1 = new Location(world, islandX, 100, islandZ);
        loc1.add(100, 100, 100);
        Location loc2 = new Location(world, islandX, 100, islandZ);
        loc2.subtract(100, 100, 100);
        Cuboid cuboid = new Cuboid(loc1, loc2);
        if (cuboid.contains(players.getLocation())) {
            e.setCancelled(false);
        }
        if (players.getWorld().equals(hubworld) && !e.isCancelled()){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }*/
}









