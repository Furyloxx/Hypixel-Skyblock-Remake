package me.adarsh.godspunkycore.features.ranks;

import me.adarsh.godspunkycore.Skyblock;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class GodspunkyPlayer {
    protected Player player;
    public static HashMap<Player, GodspunkyPlayer> players = new HashMap();
    public PlayerRank rank;
    public long lastPlayed;
    public long firstJoined;


    public GodspunkyPlayer(Player player) {
        this.player = player;
        players.put(player, this);
        FileConfiguration config = getConfig();
        if(config.getString("rank") != null) {
            this.rank = PlayerRank.valueOf(config.getString("rank"));
        }
        else {
            this.rank = PlayerRank.DEFAULT;
        }
        this.firstJoined = config.getLong("firstJoined");
        if(firstJoined == 0) {
            firstJoined = System.currentTimeMillis();
            config.set("firstJoined", firstJoined);
            save(config);
        }
        lastPlayed = config.getLong("lastPlayed");
    }

    public void saveAll() {
        FileConfiguration config = getConfig();
        config.set("lastPlayed", System.currentTimeMillis());
        config.set("rank", rank.toString());
        save(config);
    }

    public void setRank(PlayerRank rank) {
        this.rank = rank;
    }

    public void save(FileConfiguration config) {
        File file = new File(Skyblock.getPlugin().getDataFolder() + File.separator + "PlayerRanks" + File.separator + player.getUniqueId() + ".yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        File file = new File(Skyblock.getPlugin().getDataFolder() + File.separator + "PlayerRanks" + File.separator + player.getUniqueId() + ".yml");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config;
    }

    public Player getPlayer() {
        return this.player;
    }

    public static GodspunkyPlayer getUser(Player player) {
        if(players.containsKey(player))
            return players.get(player);
        return null;
    }

    public static void unloadPlayer(Player player) {
        GodspunkyPlayer rplayer = players.get(player);
        rplayer.saveAll();
        players.remove(player);
    }

    public static void savePlayers() {
        for(Player player : players.keySet()) {
            players.get(player).saveAll();
        }
    }
}

