package me.adarsh.godspunkycore.features.partyandfriends.party;

import me.adarsh.godspunkycore.features.ranks.GodspunkyPlayer;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class PartyManager {

    private final Map<UUID, PartyInstance> parties = new HashMap<>();

    public boolean createParty(GodspunkyPlayer sbPlayer) {
        if(parties.getOrDefault(sbPlayer.getPlayer().getUniqueId(), null) != null) {
            return false;
        }

        PartyInstance party = new PartyInstance(sbPlayer);
        parties.put(sbPlayer.getPlayer().getUniqueId(), party);
        return true;
    }

    public void disbandParty(GodspunkyPlayer sbLeader) {
        PartyInstance party = parties.get(sbLeader.getPlayer().getUniqueId());
        if(party == null) return;

        parties.remove(sbLeader.getPlayer().getUniqueId());
        for(GodspunkyPlayer members : party.getMembers()) {
            members.setCurrentParty(null);
            members.sendMessages(
                    "&9&m-----------------------------",
                    "&eThe party was disbanded by " + sbLeader.getPlayer().getDisplayName() + "!",
                    "&9&m-----------------------------"
            );
        }
    }

    public PartyInstance getPartyFromPlayer(UUID partyLeader) {
        return parties.getOrDefault(partyLeader, null);
    }

}
