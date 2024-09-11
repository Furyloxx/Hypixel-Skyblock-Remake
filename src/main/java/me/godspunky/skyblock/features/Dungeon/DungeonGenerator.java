package me.godspunky.skyblock.features.Dungeon;


import me.godspunky.skyblock.Repeater;
import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.entity.SEntity;
import me.godspunky.skyblock.features.entity.SEntityType;
import me.godspunky.skyblock.features.partyandfriends.party.PartyInstance;
import me.godspunky.skyblock.features.ranks.GodspunkyPlayer;
import me.godspunky.skyblock.user.PlayerUtils;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SLog;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.Sputnik;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class DungeonGenerator {

    public static String worldname = "";


    public static void startFloor(Player player) {
        long start = System.currentTimeMillis();
        Skyblock plugin = Skyblock.getPlugin();

        GodspunkyPlayer sbPlayer = GodspunkyPlayer.getUser(player);
        assert sbPlayer != null;
        PartyInstance party = sbPlayer.getCurrentParty();
        worldname = "f1_" + generateRandom();

        // Ensure that the world does not exist before creating it
        if (Bukkit.getWorld(worldname) != null) {
            SLog.severe("World '" + worldname + "' already exists!");
            return;
        }

        // Manually copy the 'f1' world from the plugin directory to the server's 'worlds' directory
        Path sourceWorldDir = plugin.getDataFolder().toPath().resolve("f1");
        Path targetWorldDir = Bukkit.getWorldContainer().toPath().resolve(worldname);

        try {
            // Copy the entire 'f1' directory to the new world directory
            Files.walk(sourceWorldDir)
                    .forEach(source -> {
                        try {
                            Path target = targetWorldDir.resolve(sourceWorldDir.relativize(source));
                            if (!Files.exists(target)) {
                                Files.copy(source, target);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            SLog.severe("Failed to copy world 'f1' to '" + worldname + "'!");
            player.sendMessage(ChatColor.RED + "Failed to create dungeon! " + ChatColor.GREEN + " Report to admin");
            e.printStackTrace();
            return;
        }

        World world = Bukkit.createWorld(new WorldCreator(worldname));

        if (world == null) {
            SLog.severe("Failed to create the world '" + worldname + "'!");
            player.sendMessage(ChatColor.RED + "Failed to create dungeon! " + ChatColor.GREEN + " Report to admin");
            return;
        }

        player.sendMessage(SUtil.getRandomVisibleColor() + "Successfully Generated Dungeon in [" + SUtil.getTimeDifferenceAndColor(start, System.currentTimeMillis()) + ChatColor.WHITE + "]");


        SUtil.delay(() -> {
            try {
                warpParty(party);
            } catch (Exception e) {
                SLog.severe("Error occurred while executing r method: " + e.getMessage());
                player.sendMessage(ChatColor.RED + "Failed to create dungeon! " + ChatColor.GREEN + " Report to admin");
            }
        }, 1L);

        SUtil.delay(() -> {
            try {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rg flag __global__ -w " + world.getName() + " build deny");
            } catch (Exception e) {
                SLog.severe("Error occurred while setting build flag: " + e.getMessage());
            }
        }, 1L);

        SUtil.delay(() -> {
            try {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rg flag __global__ -w " + world.getName() + " pvp deny");
            } catch (Exception e) {
                SLog.severe("Error occurred while setting pvp flag: " + e.getMessage());
            }
        }, 2L);


        // Start the countdown after teleportation
        int countdownDuration = 10; // in seconds
        new BukkitRunnable() {
            int countdown = countdownDuration;

            @Override
            public void run() {
                if (countdown > 0) {
                    SUtil.broadcastWorld(ChatColor.RED + "[Dungeon]: " + ChatColor.YELLOW + "Dungeon will start in " + countdown + " seconds.", world);
                    countdown--;
                } else {
                    player.sendMessage(ChatColor.GREEN + "Dungeon has started!");
                    // Trigger dungeon door animation here
                    cancel(); // Stop the countdown
                    List<Location> doorPositions = Arrays.asList(
                            new Location(world, 95, 71, 109),
                            new Location(world, 95, 71, 108),
                            new Location(world, 95, 71, 107),
                            new Location(world, 95, 70, 109),
                            new Location(world, 95, 70, 108),
                            new Location(world, 95, 70, 107),
                            new Location(world, 95, 69, 109),
                            new Location(world, 95, 69, 108),
                            new Location(world, 95, 69, 107)
                    );

                    int animationTicks = 40;

                    DungeonDoorAnimation doorAnimation = new DungeonDoorAnimation(doorPositions, animationTicks);
                    doorAnimation.startAnimation();

                    player.playSound(player.getLocation(), Sound.EXPLODE, 1.0f, 1.0f);
                }
            }
        }.runTaskTimer(Skyblock.getPlugin(), 0L, 20L);

        SEntityType type = SEntityType.UNDEAD_SKELETON;
        SEntity entity;
        Location npcLocation = new Location(world, 109, 69, 104);
        entity = new SEntity(npcLocation, type);

        SEntityType type1 = SEntityType.CRYPT_DREADLORD;
        SEntity entity1;
        Location npcLocation1 = new Location(world, 104, 69, 110);
        entity1 = new SEntity(npcLocation1, type1);

        SEntityType type2 = SEntityType.TANK_ZOMBIE;
        SEntity entity2;
        Location npcLocation2 = new Location(world, 111, 69, 108);
        entity2 = new SEntity(npcLocation2, type2);

        SEntityType type0 = SEntityType.LOST_ADVENTURER;
        SEntity entity0;
        Location npcLocation0 = new Location(world, 118, 73, 106);
        entity0 = new SEntity(npcLocation0, type0);
    }


    public static void warpParty(PartyInstance party) {
        World world = Bukkit.getWorld(worldname);
        assert world != null;

        for (GodspunkyPlayer sbPlayer : party.getMembers()) {
            sbPlayer.getPlayer().teleport(
                    new Location(world, 76, 72, 108)
            );
        }
    }


    public static void r(Player plist, World world) {
        plist.teleport(new Location(world, 76, 72, 108, 0, 0));
    }

    public static String generateRandom() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = SUtil.random(5, 6);
        Random random = new Random();
        String generatedString = ((StringBuilder) random.ints(leftLimit, rightLimit + 1).limit(targetStringLength).<StringBuilder>collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)).toString();
        return generatedString;
    }




    /*public static void deleteDungeon(Player player){
        World world = Bukkit.getWorld("Dungeon_" + player.getUniqueId());
        Bukkit.unloadWorld(world , false);
        world.getWorldFolder().deleteOnExit();
        SUtil.deleteFolderRecursive(world.getWorldFolder());

    }*/

    public static void endFloor(World w) {
        if (w.getName().toLowerCase().contains("f1") && !w.getName().toLowerCase().equals("f1")) {
            for (Entity e : w.getEntities()) {
                if (e instanceof Player)
                    continue;
                e.remove();
            }
            Bukkit.unloadWorld(w, false);
            w.getWorldFolder().deleteOnExit();
            SUtil.deleteFolderRecursive(w.getWorldFolder());
            SLog.severe("[DUNGEON BOSSROOM] Deleted " + w.getName() + " and cleaned the memory !");
        }
    }

    public void deleteAllDungeons() {
        for (World world : Bukkit.getWorlds()) {
            if (!world.getName().startsWith("f1")) return;
            Bukkit.unloadWorld(world, false);
            SUtil.deleteFolderRecursive(world.getWorldFolder());
        }
    }



    public static void sendReMsg(boolean finishornot, World w) {

        if (w.getName().contains("f1_")) {
            int floorLivingSec = Repeater.FloorLivingSec.getOrDefault(w.getUID(), 0);
                if (finishornot) {
                    int bitsReward = Math.round(((600 - Math.min(600, floorLivingSec)) * 150 / 255));
                    String rew = "&b+" + SUtil.commaify(bitsReward) + " Bits &7(Completion Reward)";
                    if (bitsReward <= 0) {
                        rew = "&cYou have no rewards!";
                    } else {
                        Collection<? extends Player> players = w.getPlayers();
                        if (!players.isEmpty()) {
                            Player player = players.iterator().next();
                            User user = User.getUser(player.getUniqueId());
                            user.addCoins(bitsReward);
                        }
                    }
                    SUtil.broadcastWorld(Sputnik.trans("&a▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"),  w);
                    SUtil.broadcastWorld(Sputnik.trans("        &cThe Catacombs Demo &8- &eFloor I"),  w);
                    SUtil.broadcastWorld(Sputnik.trans("&c"),  w);
                    SUtil.broadcastWorld(Sputnik.trans("        &c☠&e Defeated &cBonzo &ein &a"), w);
                    SUtil.broadcastWorld(Sputnik.trans("&c"),  w);
                    SUtil.broadcastWorld(Sputnik.trans("            " + rew),  w);
                    SUtil.broadcastWorld(Sputnik.trans("&c"),  w);
                    SUtil.broadcastWorld(Sputnik.trans("&a▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"),  w);
                } else {
                    SUtil.broadcastWorld(Sputnik.trans("&a▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"),  w);
                    SUtil.broadcastWorld(Sputnik.trans("        &cThe Catacombs Demo &8- &eFloor I"),  w);
                    SUtil.broadcastWorld(Sputnik.trans("&c"),  w);
                    SUtil.broadcastWorld(Sputnik.trans("        &c☠&e You died, but you can try again!"),  w);
                    SUtil.broadcastWorld(Sputnik.trans("&c"),  w);
                    SUtil.broadcastWorld(Sputnik.trans("           &cYou have no rewards cause you died."),  w);
                    SUtil.broadcastWorld(Sputnik.trans("&c"),  w);
                    SUtil.broadcastWorld(Sputnik.trans("&a▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"),  w);
                }
        }
    }


    public static void endRoom2(World w) {
        if (w.getName().contains("f1")) {
            Collection<? extends Player> players = w.getPlayers();
            if (!players.isEmpty()) {
                Player p = players.iterator().next();

                SUtil.delay(() -> SUtil.broadcastWorld(Sputnik.trans("&c[Warning] &eThis dungeon will close in &c5s"), w), 200L);
                SUtil.delay(() -> SUtil.broadcastWorld(Sputnik.trans("&c[Warning] &eThis dungeon will close in &c4s"), w), 220L);
                SUtil.delay(() -> SUtil.broadcastWorld(Sputnik.trans("&c[Warning] &eThis dungeon will close in &c3s"), w), 240L);
                SUtil.delay(() -> SUtil.broadcastWorld(Sputnik.trans("&c[Warning] &eThis dungeon will close in &c2s"), w), 260L);
                SUtil.delay(() -> SUtil.broadcastWorld(Sputnik.trans("&c[Warning] &eThis dungeon will close in &c1s"), w), 280L);
                SUtil.delay(() -> SUtil.broadcastWorld(Sputnik.trans("&c[Warning] &eWarping you back to the Hub"), w), 300L);
                SUtil.delay(() -> PlayerUtils.sendToIsland(p), 310L);
                SUtil.delay(() -> endFloor(w), 300L);
            }
        }
    }
}