package me.adarsh.godspunkycore.features.Dungeon;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.entity.SEntity;
import me.adarsh.godspunkycore.features.entity.SEntityType;
import me.adarsh.godspunkycore.util.BlankWorldCreator;
import me.adarsh.godspunkycore.util.SUtil;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DungeonGenerator {

    public void CreateDungeon(Player player) {
        long start = System.currentTimeMillis();
        World world = new BlankWorldCreator("Dungeon_" + player.getUniqueId()).createWorld();
        File file = new File("plugins/GodSpunkySkyblockCore/floor1.schematic");
        SUtil.pasteSchematic(file, new Location(world, 0, 100.0, 0), true);
        Location teleportLocation = new Location(world, 22,106,-56);
        player.teleport(teleportLocation);
        player.sendMessage(SUtil.getRandomVisibleColor() + "Successfully Generated Dungeon in [" + SUtil.getTimeDifferenceAndColor(start, System.currentTimeMillis()) + ChatColor.WHITE + "]");

        // Start the countdown after teleportation
        int countdownDuration = 20; // in seconds
        new BukkitRunnable() {
            int countdown = countdownDuration;

            @Override
            public void run() {
                if (countdown > 0) {
                    player.sendMessage(ChatColor.RED + "[Dungeon] : " + ChatColor.YELLOW + "Dungeon will start in " + countdown + " seconds.");
                    countdown--;
                } else {
                    player.sendMessage(ChatColor.GREEN + "Dungeon has started!");
                    // Trigger dungeon door animation here
                    cancel(); // Stop the countdown
                    List<Location> doorPositions = Arrays.asList(
                            new Location(world, 21, 105, -38),
                            new Location(world, 22, 105, -38),
                            new Location(world, 23, 105, -38),
                            new Location(world, 21, 104, -38),
                            new Location(world, 22, 104, -38),
                            new Location(world, 23, 104, -38),
                            new Location(world, 21, 103, -38),
                            new Location(world, 22, 103, -38),
                            new Location(world, 23, 103, -38)
                    );
                    List<Location> row1 = Arrays.asList(
                            new Location(world, 23, 105, -38),
                            new Location(world, 22, 105, -38),
                            new Location(world, 21, 105, -38)
                    );
                    List<Location> row2 = Arrays.asList(
                            new Location(world, 23, 104, -38),
                            new Location(world, 22, 104, -38),
                            new Location(world, 21, 104, -38)
                    );
                    List<Location> row3 = Arrays.asList(
                            new Location(world, 23, 103, -38),
                            new Location(world, 22, 103, -38),
                            new Location(world, 21, 103, -38)
                    );

                    int animationTicks = 40;

                    DungeonDoorAnimation doorAnimation = new DungeonDoorAnimation(doorPositions, animationTicks);
                    doorAnimation.startAnimation();

                    SEntityType type = SEntityType.LOST_ADVENTURER;
                    SEntity entity;
                    Location npcLocation = new Location(world, 22,103,-23);
                    entity = new SEntity(npcLocation, type);
                    player.playSound(player.getLocation(), Sound.EXPLODE, 1.0f, 1.0f);
                    player.sendMessage(ChatColor.GOLD + "Kill " + entity.getStatistics().getEntityName() + " To Spawn Bonzo");

                }
            }
        }.runTaskTimer(Skyblock.getPlugin(), 0L, 20L); // Run the task every second (20 ticks)
    }



    public static void deleteDungeon(Player player) {
        World world = Bukkit.getWorld("Dungeon_" + player.getUniqueId());
        Bukkit.unloadWorld(world, false);
        SUtil.deleteFolderRecursive(world.getWorldFolder());
    }

    public static void deleteAllDungeons() {
        for (World world : Bukkit.getWorlds()) {
            if (world.getName().startsWith("Dungeon")) {
                Bukkit.unloadWorld(world, false);
                SUtil.deleteFolderRecursive(world.getWorldFolder());
            }
        }
    }
}


