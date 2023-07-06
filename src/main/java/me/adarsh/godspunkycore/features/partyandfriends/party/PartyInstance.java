package me.adarsh.godspunkycore.features.partyandfriends.party;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.ranks.GodspunkyPlayer;
import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PartyInstance {

    private final GodspunkyPlayer leader;
    private final List<GodspunkyPlayer> partyMembers = new ArrayList<>();
    private final List<GodspunkyPlayer> invitedPlayers = new ArrayList<>();

    private final Map<GodspunkyPlayer, Integer> permissions = new HashMap<>();

    public PartyInstance(GodspunkyPlayer sbLeader) {
        leader = sbLeader;
        partyMembers.add(sbLeader);
        permissions.put(sbLeader, 2);

        sbLeader.setCurrentParty(this);
    }

    public void dispatchInvite(GodspunkyPlayer inviter, GodspunkyPlayer toInvite) {
        if (inParty(toInvite)) {
            inviter.sendMessages(
                    "&9&m-----------------------------",
                    "&cThat player is already in your party!",
                    "&9&m-----------------------------"
            );
            return;
        }

        if (inviter == toInvite) {
            inviter.sendMessages(
                    "&9&m-----------------------------",
                    "&cYou can't invite yourself!",
                    "&9&m-----------------------------"
            );
            return;
        }

        invitedPlayers.add(toInvite);

        new BukkitRunnable() {
            @Override
            public void run() {
                if (inParty(toInvite)) return;
                if (!invitedPlayers.contains(toInvite)) return;

                invitedPlayers.remove(toInvite);
                toInvite.sendMessages(
                        "&9&m-----------------------------",
                        "&eThe party invite from " + inviter.getPlayer().getDisplayName() + " has expired.",
                        "&9&m-----------------------------"
                );

                for (GodspunkyPlayer member : partyMembers) {
                    member.sendMessages(
                            "&9&m-----------------------------",
                            "&eThe party invite to " +toInvite.getPlayer().getDisplayName() + " has expired",
                            "&9&m-----------------------------"
                    );
                }
            }
        }.runTaskLater(Skyblock.getPlugin(), 20 * 60L);

        String inviterName = inviter.getPlayer().getDisplayName();


        String inviteMessage = "&9&m-----------------------------\n" +
                ChatColor.GRAY+inviter.getPlayer().getName()+ " &e has invited you to join their party!\n" +
                "&aClick to accept: &7/party accept " + inviter.getPlayer().getName() + "\n" +
                "&cClick to deny: &7/party deny " + inviter.getPlayer().getName() + "\n" +
                "&9&m-----------------------------";

        toInvite.sendMessage(inviteMessage);
    }




    public void addMember(GodspunkyPlayer player) {
        if (inParty(player)) return;
        invitedPlayers.remove(player);

        player.sendMessages(
                "&9&m-----------------------------",
                "&eYou have joined " + leader.getPlayer().getDisplayName() + "'s party!",
                "&9&m-----------------------------"
        );

        for (GodspunkyPlayer member : partyMembers) {
            member.sendMessages(
                    "&9&m-----------------------------",
                    "&e" + player.getPlayer().getDisplayName() + " joined the party.",
                    "&9&m-----------------------------"
            );
        }

        partyMembers.add(player);
        player.setCurrentParty(this);
        player.setPartyPermissions(0);
    }

    public void removeMember(GodspunkyPlayer player) {
        if (!inParty(player)) return;

        player.sendMessages(
                "&9&m-----------------------------",
                "&eYou left the party.",
                "&9&m-----------------------------"
        );

        partyMembers.remove(player);

        for (GodspunkyPlayer member : partyMembers) {
            if (member == player) continue;
            String message;
            if (player.rank == PlayerRank.DEFAULT) {
                message = "&7" + player.getPlayer().getDisplayName() + " has left the party.";
            } else {
                message =  player.getPlayer().getDisplayName() + " has left the party.";
            }
            member.sendMessages(
                    "&9&m-----------------------------",
                    message,
                    "&9&m-----------------------------"
            );
        }

        player.setCurrentParty(null);
    }



    public void kickMember(GodspunkyPlayer kicker, GodspunkyPlayer toKick) {
        if (!inParty(toKick)) {
            kicker.sendMessages(
                    "&9&m-----------------------------",
                    "&cThat player isn't in the party.",
                    "&9&m-----------------------------"
            );
            return;
        }

        toKick.sendMessages(
                "&9&m-----------------------------",
                "&eYou have been kicked from the party by " + kicker.getPlayer().getDisplayName(),
                "&9&m-----------------------------"
        );

        partyMembers.remove(toKick);
        toKick.setCurrentParty(null);

        for (GodspunkyPlayer member : partyMembers) {
            member.sendMessages(
                    "&9&m-----------------------------",
                    "&e" + toKick.getPlayer().getDisplayName() + " has been removed from the party.",
                    "&9&m-----------------------------"
            );
        }
    }

    public List<GodspunkyPlayer> getMembers() {
        return partyMembers;
    }

    public void sendMessages(String... messages) {
        for (GodspunkyPlayer member : getMembers()) {
            for (String message : messages) {
                member.sendMessage(message);
            }
        }
    }
    //hm

    public void setPermissions(GodspunkyPlayer player, int permission) {
        permissions.put(player, permission);
    }

    public boolean inParty(GodspunkyPlayer player) {
        return partyMembers.contains(player);
    }

    public GodspunkyPlayer getLeader() {
        return leader;
    }

    public boolean hasInvite(GodspunkyPlayer player) {
        return invitedPlayers.contains(player);
    }

    public int getPlayerPermissions(GodspunkyPlayer player) {
        return permissions.getOrDefault(player, 0);
    }

}
