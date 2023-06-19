package me.adarsh.godspunkycore;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;


public class SkyblockPlayer {
    private HashMap<String, Object> extraData;
    public static HashMap<UUID, SkyblockPlayer> playerRegistry = new HashMap<>();

    public static SkyblockPlayer getPlayer(Player player) {
        return playerRegistry.get(player.getUniqueId());
    }

    public static SkyblockPlayer getPlayer(UUID uuid) {
        return playerRegistry.get(uuid);
    }

    public Object getExtraData(String id) {
        return extraData.get(id);
    }

    public void setExtraData(String id, Object obj) {
        extraData.put(id, obj);
    }

}
