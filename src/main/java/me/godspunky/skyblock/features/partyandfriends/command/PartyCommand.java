package me.godspunky.skyblock.features.partyandfriends.command;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.command.CommandParameters;
import me.godspunky.skyblock.command.CommandSource;
import me.godspunky.skyblock.command.SCommand;
import me.godspunky.skyblock.features.partyandfriends.party.PartyInstance;
import me.godspunky.skyblock.features.partyandfriends.party.PartyManager;
import me.godspunky.skyblock.features.ranks.GodspunkyPlayer;
import me.godspunky.skyblock.features.ranks.PlayerRank;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandParameters(
        description = "Adds to Party",
        aliases = "p",
        permission = PlayerRank.DEFAULT)

public final class PartyCommand extends SCommand {

    @Override
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        GodspunkyPlayer sbPlayer = GodspunkyPlayer.getUser(player);

        switch (args.length) {
            default:
                if (!args[0].equals("chat")) return;

                if (sbPlayer.getCurrentParty() == null) {
                    sbPlayer.sendMessages(
                            "&9&m-----------------------------",
                            "&cYou're not in a party!",
                            "&9&m-----------------------------"
                    );
                    return;
                }

                StringBuilder message = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    message.append(args[i]).append(" ");
                }

                PartyInstance partyInstance = sbPlayer.getCurrentParty();
                for (GodspunkyPlayer member : partyInstance.getMembers()) {
                    PlayerRank rank = member.rank;
                    String formattedRank = rank.isDefaultPermission() ? "&7" : rank.getPrefix();
                    member.sendMessage("&9Party &8> " + formattedRank + player.getName() + "&f: " + message);
                }
                return;
            case 0:
                sbPlayer.sendMessages(
                        "&9&m-----------------------------",
                        "&e/party accept <player>",
                        "&e/party invite <player>",
                        "&e/party leave",
                        "&e/party disband",
                        "&e/party chat <message>",
                        "&9&m-----------------------------"
                );
                return;
            case 1:
                switch (args[0]) {
                    default:
                        String playerName = args[0];
                        Player invitedPlayer = Bukkit.getPlayer(playerName);
                        if (invitedPlayer == null) return;

                        GodspunkyPlayer invite = GodspunkyPlayer.getUser(invitedPlayer);

                        PartyManager partyManager = Skyblock.getPartyManager();
                        if (!partyManager.createParty(sbPlayer)) {
                            sbPlayer.sendMessages(
                                    "&9&m-----------------------------",
                                    "&cYou're already in a party!",
                                    "&9&m-----------------------------"
                            );
                            return;
                        }

                        PartyInstance createParty = partyManager.getPartyFromPlayer(sbPlayer.getPlayer().getUniqueId());
                        createParty.dispatchInvite(sbPlayer, invite);
                        return;
                    case "leave":
                        PartyInstance leaveParty = sbPlayer.getCurrentParty();
                        if (leaveParty == null) return;

                        leaveParty.removeMember(sbPlayer);
                        return;
                    case "disband":
                        PartyInstance disbandParty = sbPlayer.getCurrentParty();
                        if (disbandParty == null) return;

                        if (sbPlayer.getPartyPermissions() != 2) {
                            sbPlayer.sendMessages(
                                    "&9&m-----------------------------",
                                    "&cYou have to be the leader to do that!",
                                    "&9&m-----------------------------"
                            );
                            return;
                        }

                        PartyManager partyManager1 = Skyblock.getPartyManager();
                        partyManager1.disbandParty(sbPlayer);
                        return;
                    case "debug":
                        sbPlayer.sendMessage("Party Permissions: " + sbPlayer.getPartyPermissions());
                        return;
                }
            case 2:
                switch (args[0]) {
                    default:
                        sbPlayer.sendMessages(
                                "&9&m-----------------------------",
                                "&e/party accept <player>",
                                "&e/party invite <player>",
                                "&e/party leave",
                                "&e/party disband",
                                "&e/party chat <message>",
                                "&9&m-----------------------------"
                        );
                        return;
                    case "invite":
                        String playerName = args[1];
                        Player invitedPlayer = Bukkit.getPlayer(playerName);
                        if (invitedPlayer == null) return;

                        GodspunkyPlayer invite = GodspunkyPlayer.getUser(invitedPlayer);

                        PartyManager partyManager = Skyblock.getPartyManager();
                        partyManager.createParty(sbPlayer);

                        sbPlayer.sendMessages(
                                "&9&m----------------------------------------------------",
                                "&eYou have invited "+getPlayerRank(invitedPlayer).getFormattedRank()+invitedPlayer.getDisplayName()+" to the party! They have 60 seconds to accept",
                                "&9&m----------------------------------------------------"
                        );

                        PartyInstance createParty = partyManager.getPartyFromPlayer(sbPlayer.getPlayer().getUniqueId());
                        createParty.dispatchInvite(sbPlayer, invite);
                        return;
                    case "accept":
                        if (sbPlayer.getCurrentParty() != null) {
                            sbPlayer.sendMessages(
                                    "&9&m-----------------------------",
                                    "&cYou're already in a party!",
                                    "&9&m-----------------------------"
                            );
                            return;
                        }

                        String leaderName = args[1];
                        Player leader = Bukkit.getPlayer(leaderName);
                        if (leader == null) return;

                        PartyManager partyManager1 = Skyblock.getPartyManager();
                        if (partyManager1.getPartyFromPlayer(leader.getUniqueId()) == null) return;
                        PartyInstance party = partyManager1.getPartyFromPlayer(leader.getUniqueId());

                        if (!party.hasInvite(sbPlayer)) return;
                        party.addMember(sbPlayer);
                        return;
                    case "kick":
                        String playerName1 = args[1];
                        Player kickPlayer = Bukkit.getPlayer(playerName1);
                        if (kickPlayer == null) return;

                        if (sbPlayer.getPartyPermissions() == 0) {
                            sbPlayer.sendMessages(
                                    "&9&m-----------------------------",
                                    "&cYou do not have permission to do that!",
                                    "&9&m-----------------------------"
                            );
                            return;
                        }

                        PartyInstance party1 = sbPlayer.getCurrentParty();
                        party1.kickMember(sbPlayer, GodspunkyPlayer.getUser(kickPlayer));
                        return;
                    case "chat":
                        if (sbPlayer.getCurrentParty() == null) {
                            sbPlayer.sendMessages(
                                    "&9&m-----------------------------",
                                    "&cYou're not in a party!",
                                    "&9&m-----------------------------"
                            );
                            return;
                        }

                        StringBuilder message2 = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            message2.append(args[i]).append(" ");
                        }

                        PartyInstance partyInstance2 = sbPlayer.getCurrentParty();
                        for (GodspunkyPlayer member : partyInstance2.getMembers()) {
                            PlayerRank rank = member.rank;
                            String formattedRank = rank.isDefaultPermission() ? "&7" : rank.getPrefix();
                            member.sendMessage("&9Party &8> " + formattedRank + player.getName() + "&f: " + message2);
                        }
                        return;
                }
        }
    }
}
