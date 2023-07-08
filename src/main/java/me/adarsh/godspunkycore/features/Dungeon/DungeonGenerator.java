package me.adarsh.godspunkycore.features.Dungeon;

import me.adarsh.godspunkycore.features.entity.SEntity;
import me.adarsh.godspunkycore.features.entity.SEntityType;
import me.adarsh.godspunkycore.util.BlankWorldCreator;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DungeonGenerator {

    public void CreateDungeon(Player player){
        long start = System.currentTimeMillis();
        World world = new BlankWorldCreator("Dungeon_" + player.getUniqueId()).createWorld(); // todo use team id instead of player
        File file = new File("plugins/GodSpunkySkyblockCore/floor1.schematic");
        SEntityType type = SEntityType.LOST_ADVENTURER;
        SEntity entity;
        SUtil.pasteSchematic(file, new Location(world, 0, 100.0, 0 ), true);
        player.teleport(new Location(world , 15 , 104 , -50));
        player.sendMessage(SUtil.getRandomVisibleColor() + "Successfully Generated Dungeon in ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
        Location loc = new Location(world, 15, 102 , -12);
        entity = new SEntity(loc, type);
        player.playSound(player.getLocation(), Sound.EXPLODE,1.0f,1.0f);
        player.sendMessage(ChatColor.GOLD+"Kill " + entity.getStatistics().getEntityName() + " To Spawn Bonzo");
    }


    public void deleteDungeon(Player player){
        World world = Bukkit.getWorld("Dungeon_" + player.getUniqueId());
        Bukkit.unloadWorld(world , false);
        SUtil.deleteFolderRecursive(world.getWorldFolder());
    }
    public void deleteAllDungeons(){
        for (World world : Bukkit.getWorlds()){
            if (!world.getName().startsWith("Dungeon")) return;
            Bukkit.unloadWorld(world , false);
            SUtil.deleteFolderRecursive(world.getWorldFolder());
            }
        }
    }


