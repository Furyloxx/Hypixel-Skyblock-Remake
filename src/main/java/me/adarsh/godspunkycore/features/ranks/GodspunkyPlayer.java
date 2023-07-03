package me.adarsh.godspunkycore.features.ranks;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.partyandfriends.party.PartyInstance;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class GodspunkyPlayer {
    protected Player player;
    public static HashMap<Player, GodspunkyPlayer> players = new HashMap<>();
    public PlayerRank rank;
    public long lastPlayed;
    public long firstJoined;

    private PartyInstance currentParty = null;

    public Skyblock.ChatTypes currentChat = Skyblock.ChatTypes.ALL_CHAT;
    private static Skyblock plugin = Skyblock.getPlugin();



    public GodspunkyPlayer(Player player) {
        this.player = player;
        players.put(player, this);
        FileConfiguration config = getConfig();
        if (config.getString("rank") != null) {
            this.rank = PlayerRank.valueOf(config.getString("rank"));
        } else {
            this.rank = PlayerRank.DEFAULT;
        }
        this.firstJoined = config.getLong("firstJoined");
        if (firstJoined == 0) {
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
        File file = new File(plugin.getDataFolder() + File.separator + "PlayerRanks" + File.separator + player.getUniqueId() + ".yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        File file = new File(plugin.getDataFolder() + File.separator + "PlayerRanks" + File.separator + player.getUniqueId() + ".yml");
        if (!file.exists()) {
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
        if (players.containsKey(player))
            return players.get(player);
        return null;
    }

    public static void unloadPlayer(Player player) {
        GodspunkyPlayer rplayer = players.get(player);
        rplayer.saveAll();
        players.remove(player);

    }

    public static void savePlayers() {
        for (Player player : players.keySet()) {
            players.get(player).saveAll();
        }
    }

    public void setCurrentParty(Object partyInstance) {
        if(partyInstance instanceof PartyInstance) {
            currentParty = (PartyInstance) partyInstance;
        } else {
            currentParty = null;
        }
    }

    public void setPartyPermissions(int partyPermission) {
        if(!inParty()) return;

        getCurrentParty().setPermissions(this, partyPermission);
    }

    public PartyInstance getCurrentParty() {
        return currentParty;
    }

    public boolean inParty() {
        return currentParty != null;
    }

    public int getPartyPermissions() {
        if(!inParty()) return 0;

        return getCurrentParty().getPlayerPermissions(this);
    }

    //hm

    public void sendMessage(Object message) {
        if (message instanceof String) {
            player.sendMessage(message.toString().replace('&', ChatColor.COLOR_CHAR));
        } else if (message instanceof TextComponent) {
            player.spigot().sendMessage(new BaseComponent[]{(BaseComponent) message});
        }
    }



    public void sendMessages(Object... messages) {
        for(Object message : messages) {
            sendMessage(message);
        }
    }
}
