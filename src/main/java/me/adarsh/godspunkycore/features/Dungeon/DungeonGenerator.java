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
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.io.File;
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


    public static void startFloor(ArrayList<Player> plist) {
        String worldname = "f1_" + generateRandom();
        MVWorldManager worldManager = Skyblock.core.getMVWorldManager();
        if (worldManager == null) {
            SLog.severe("WorldManager is not enabled!");
            return;
        }
        worldManager.cloneWorld("f1", worldname);
        worldManager.loadWorld(worldname);
        World world = Bukkit.getWorld(worldname);
        for (Player tm : plist)
            tm.teleport(new Location(world, 213.0D, 71.0D, 221.0D, 0.0F, 0.0F));
        SUtil.delay(() -> r(plist, world), 1L);
        SUtil.delay(() -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rg flag __global__ -w " + world.getName() + " build deny"), 1L);
        SUtil.delay(() -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rg flag __global__ -w " + world.getName() + " pvp deny"), 2L);
        SUtil.delay(() -> new SEntity(new Location(world, 183.0D, 100.0D, 251.0D), SEntityType.SADAN, new Object[0]), 1L);
    }

    public static void r(ArrayList<Player> plist, World world) {
        for (Player tm : plist)
            tm.teleport(new Location(world, 191.5D, 69.0D, 199.5D, 0.0F, 0.0F));
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
        if (w.getName().contains("f1_"))
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