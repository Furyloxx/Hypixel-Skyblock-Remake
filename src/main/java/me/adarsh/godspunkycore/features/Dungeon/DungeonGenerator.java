package me.adarsh.godspunkycore.features.Dungeon;

import me.adarsh.godspunkycore.util.BlankWorldCreator;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.UUID;

public class DungeonGenerator {

    public void CreateDungeon(Player player){
        long start = System.currentTimeMillis();
        World world = new BlankWorldCreator("Dungeon_" + player.getUniqueId()).createWorld(); // todo use team id instead of player
        File file = new File("plugins/GodSpunkySkyblockCore/f1.schematic");
        SUtil.pasteSchematic(file, new Location(world, 0, 100.0, 0 ), true);
        player.teleport(new Location(world , 2 , 100 , -1));
        player.sendMessage(SUtil.getRandomVisibleColor() + "Successfully Generated Dungeon in ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }
    public void deleteDungeon(Player player){
        World world = Bukkit.getWorld("Dungeon_" + player.getUniqueId());
        SUtil.deleteFolderRecursive(world.getWorldFolder());
    }
    public void deleteAllDungeons(){
        for (World world : Bukkit.getWorlds()){
            if (!world.getName().startsWith("Dungeon")) return;
            SUtil.deleteFolderRecursive(world.getWorldFolder());
            }
        }
    }


