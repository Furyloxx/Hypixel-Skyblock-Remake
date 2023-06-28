package me.adarsh.godspunkycore;

import org.apache.commons.io.LineIterator;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Consumer;


public class SkyblockPlayer {
    private HashMap<String, Object> extraData;
    public static HashMap<UUID, SkyblockPlayer> playerRegistry = new HashMap<>();

    public SkyblockPlayer(UUID uuid) {

    }

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
    public static void registerPlayer(UUID uuid, PlayerJoinEvent event, Consumer<SkyblockPlayer> after) {
        playerRegistry.put(uuid, new SkyblockPlayer(uuid));

        SkyblockPlayer player = playerRegistry.get(uuid);

        after.accept(player);
    }
}
