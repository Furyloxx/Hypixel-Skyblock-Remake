package me.adarsh.godspunkycore.features.Dungeon;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import me.adarsh.godspunkycore.Repeater;
import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.entity.SEntity;
import me.adarsh.godspunkycore.features.entity.SEntityType;
import me.adarsh.godspunkycore.util.BlankWorldCreator;
import me.adarsh.godspunkycore.util.SLog;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.Sputnik;
import org.apache.commons.io.FileUtils;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DungeonGenerator {

    /*public void CreateDungeon(Player player){
        long start = System.currentTimeMillis();
        World world = new BlankWorldCreator("Dungeon_" + player.getUniqueId()).createWorld(); // todo use team id instead of player
        File file = new File("plugins/GodSpunkySkyblockCore/floor1.schematic");
        SEntityType type = SEntityType.LOST_ADVENTURER;
        SEntity entity;
        SUtil.pasteSchematic(file, new Location(world, 0, 100.0, 0 ), false);
        player.teleport(new Location(world , 15 , 104 , -50));
        player.sendMessage(SUtil.getRandomVisibleColor() + "Successfully Generated Dungeon in ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
        Location loc = new Location(world, 15, 102 , -12);
        entity = new SEntity(loc, type);
        player.playSound(player.getLocation(), Sound.EXPLODE,1.0f,1.0f);
        player.sendMessage(ChatColor.GOLD+"Kill " + entity.getStatistics().getEntityName() + " To Spawn Bonzo");
    }*/


    public static void startFloor(Player plist) {
        Skyblock plugin = Skyblock.getPlugin();
        String worldname = "f1_" + plist.getName();

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
            e.printStackTrace();
            return;
        }

        World world = Bukkit.createWorld(new WorldCreator(worldname));

        if (world == null) {
            SLog.severe("Failed to create the world '" + worldname + "'!");
            return;
        }

        plist.teleport(new Location(world, 157.0D, 71.0D, 220.0D, 0.0F, 0.0F));

        SUtil.delay(() -> {
            try {
                r(plist, world);
            } catch (Exception e) {
                SLog.severe("Error occurred while executing r method: " + e.getMessage());
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

        SUtil.delay(() -> {
            try {
                new SEntity(new Location(world, 183.0D, 100.0D, 251.0D), SEntityType.SADAN, new Object[0]);
            } catch (Exception e) {
                SLog.severe("Error occurred while spawning SEntity: " + e.getMessage());
            }
        }, 1L);
    }





    public static void r(Player plist, World world) {
      plist.teleport(new Location(world, 191.5D, 69.0D, 199.5D, 0.0F, 0.0F));
    }

    public static String generateRandom() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = SUtil.random(5, 6);
        Random random = new Random();
        String generatedString = ((StringBuilder)random.ints(leftLimit, rightLimit + 1).limit(targetStringLength).<StringBuilder>collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)).toString();
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
            Skyblock.core.deleteWorld(w.getName());
            SLog.severe("[DUNGEON BOSSROOM] Deleted " + w.getName() + " and cleaned the memory !");
        }
    }

    public void deleteAllDungeons(){
        for (World world : Bukkit.getWorlds()){
            if (!world.getName().startsWith("Dungeon")) return;
            Bukkit.unloadWorld(world , false);
            SUtil.deleteFolderRecursive(world.getWorldFolder());
        }
    }

    public static void sendReMsg(boolean finishornot, World w , Player player) {
        if (w.getName().contains("f1"))
            if (Repeater.FloorLivingSec.containsKey(w.getUID()))
                if (finishornot) {
                    int bitsReward = Math.round(((600 - Math.min(600, (Integer) Repeater.FloorLivingSec.get(w.getUID()))) * 150 / 255));
                    String rew = "&b+" + SUtil.commaify(bitsReward) + " Bits &7(Completion Reward)";
                    player.sendMessage(Sputnik.trans("&a▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                    player.sendMessage(Sputnik.trans("        &cThe Catacombs Demo &8- &eFloor I"));
                    player.sendMessage(Sputnik.trans("&c"));
                    player.sendMessage(Sputnik.trans("        &c☠&e Defeated &cSadan &ein &a" + Sputnik.formatTime((Integer) Repeater.FloorLivingSec.get(w.getUID()))));
                    player.sendMessage(Sputnik.trans("&c"));
                    player.sendMessage(Sputnik.trans("            " + rew));
                    player.sendMessage(Sputnik.trans("&c"));
                    player.sendMessage(Sputnik.trans("&a▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                } else {
                    player.sendMessage(Sputnik.trans("&a▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                    player.sendMessage(Sputnik.trans("        &cThe Catacombs Demo &8- &eFloor VI"));
                    player.sendMessage(Sputnik.trans("&c"));
                    player.sendMessage(Sputnik.trans("        &c☠&e You died, but you can try again!"));
                    player.sendMessage(Sputnik.trans("&c"));
                    player.sendMessage(Sputnik.trans("           &cYou have no rewards cause you died."));
                    player.sendMessage(Sputnik.trans("&c"));
                    player.sendMessage(Sputnik.trans("&a▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                }
    }

    public static void endRoom2(World w, Player p) {
        if (w.getName().contains("f1")) {
            SUtil.delay(() -> p.sendMessage(Sputnik.trans("&c[Warning] &eThis dungeon will close in &c5s")), 200L);
            SUtil.delay(() -> p.sendMessage(Sputnik.trans("&c[Warning] &eThis dungeon will close in &c4s")), 220L);
            SUtil.delay(() -> p.sendMessage(Sputnik.trans("&c[Warning] &eThis dungeon will close in &c3s")), 240L);
            SUtil.delay(() -> p.sendMessage(Sputnik.trans("&c[Warning] &eThis dungeon will close in &c2s")), 260L);
            SUtil.delay(() -> p.sendMessage(Sputnik.trans("&c[Warning] &eThis dungeon will close in &c1s")), 280L);
            SUtil.delay(() -> p.sendMessage(Sputnik.trans("&c[Warning] &eWarping you back to the Hub")), 300L);
            SUtil.delay(() -> endFloor(w), 300L);
        }
    }
}