package me.godspunky.skyblock.listener;

import me.godspunky.skyblock.command.RegionCommand;
import me.godspunky.skyblock.command.SetLaunchPad;
import me.godspunky.skyblock.features.launchpads.LaunchPadHandler;
import me.godspunky.skyblock.features.launchpads.PadGenerator;
import me.godspunky.skyblock.features.region.Cuboid;
import me.godspunky.skyblock.features.region.Region;
import me.godspunky.skyblock.features.region.RegionGenerator;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
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
    public void PadCreation(PlayerInteractEvent e){
        Block block = e.getClickedBlock();
        if (block == null) return;
        Player player = e.getPlayer();
        if (!SetLaunchPad.PAD_GENERATION_MAP.containsKey(player)) return;
        e.setCancelled(true);
        PadGenerator generator = SetLaunchPad.PAD_GENERATION_MAP.get(player);
        switch (generator.getPhase()){
            case 1 : {
                generator.setStartLocation(block.getLocation());
                generator.setPhase(2);
                player.sendMessage(ChatColor.GRAY + "added your clicked block as the start location!");
                player.sendMessage(ChatColor.DARK_AQUA + "Click on the second location block!");
                break;
            }
            case 2 : {
                generator.setEndLocation(block.getLocation());
                generator.setPhase(3);
                player.sendMessage(ChatColor.GRAY + "added your clicked block as the end location!");
                player.sendMessage(ChatColor.DARK_AQUA + "Click on the 3rd block for teleport location!");
                break;

            }
            case 3 : {
                generator.setTeleportLocation(block.getLocation());
                LaunchPadHandler handler = new LaunchPadHandler();
                handler.savePad(generator.getStart() , generator.getEnd() , generator.getStartLocation() , generator.getEndLocation() , generator.getTeleportLocation());
                player.sendMessage(ChatColor.GREEN + "Created LaunchPad!");
                SetLaunchPad.PAD_GENERATION_MAP.remove(player);

            }


        }


    }

    @EventHandler
    public void BlockPlace(BlockPlaceEvent e) {
        if (!e.getPlayer().getWorld().equals(Bukkit.getWorld("islands"))) return;
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
        if (!e.getPlayer().getWorld().equals(Bukkit.getWorld("islands"))) return; // if it not island world then return otherwise region system wont work
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









