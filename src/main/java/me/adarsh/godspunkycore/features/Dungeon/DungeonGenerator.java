package me.adarsh.godspunkycore.features.Dungeon;

import me.adarsh.godspunkycore.Repeater;
import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.entity.SEntity;
import me.adarsh.godspunkycore.features.entity.SEntityType;
import me.adarsh.godspunkycore.util.BlankWorldCreator;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.Sputnik;
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
        SUtil.pasteSchematic(file, new Location(world, 0, 100.0, 0 ), false);
        player.teleport(new Location(world , 15 , 104 , -50));
        player.sendMessage(SUtil.getRandomVisibleColor() + "Successfully Generated Dungeon in ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
        Location loc = new Location(world, 15, 102 , -12);
        entity = new SEntity(loc, type);
        player.playSound(player.getLocation(), Sound.EXPLODE,1.0f,1.0f);
        player.sendMessage(ChatColor.GOLD+"Kill " + entity.getStatistics().getEntityName() + " To Spawn Bonzo");
    }


    public static void deleteDungeon(Player player){
        World world = Bukkit.getWorld("Dungeon_" + player.getUniqueId());
        Bukkit.unloadWorld(world , false);
        world.getWorldFolder().deleteOnExit();
        SUtil.deleteFolderRecursive(world.getWorldFolder());

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
}