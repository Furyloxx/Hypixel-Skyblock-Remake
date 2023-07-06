package me.adarsh.godspunkycore.features.partyandfriends.listener;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.partyandfriends.party.PartyInstance;
import me.adarsh.godspunkycore.features.ranks.GodspunkyPlayer;
import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
//hm


public final class ChatListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        GodspunkyPlayer.getUser(player);

        GodspunkyPlayer sbPlayer = GodspunkyPlayer.getUser(player);
        Skyblock.ChatTypes chatType = sbPlayer.currentChat;

        switch(chatType) {
            default:
            case ALL_CHAT:
                return;
            case PARTY_CHAT:
                event.setCancelled(true);

                PartyInstance partyInstance = sbPlayer.getCurrentParty();
                if(partyInstance == null) {
                    sbPlayer.sendMessages("&cYou have to be in a party to use that!");
                    sbPlayer.currentChat = Skyblock.ChatTypes.ALL_CHAT;
                    return;
                }

                // TODO : FIX RANK

                PlayerRank rank = sbPlayer.rank;
                String message = "&9Party &8> " + sbPlayer.getPlayer().getDisplayName() + "&f: " + event.getMessage();
                partyInstance.sendMessages(message);

        }
    }

}
