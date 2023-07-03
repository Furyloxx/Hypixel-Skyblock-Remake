package me.adarsh.godspunkycore.features.partyandfriends.command;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.command.CommandParameters;
import me.adarsh.godspunkycore.command.CommandSource;
import me.adarsh.godspunkycore.command.SCommand;
import me.adarsh.godspunkycore.features.partyandfriends.party.PartyInstance;
import me.adarsh.godspunkycore.features.partyandfriends.party.PartyManager;
import me.adarsh.godspunkycore.features.ranks.GodspunkyPlayer;
import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandParameters(
        description = "Adds to Party",
        permission = PlayerRank.DEFAULT)

public final class PartyCommand extends SCommand {

    @Override
    public void run(CommandSource sender, String[] args) {
        Player p = sender.getPlayer();
        GodspunkyPlayer sbPlayer = GodspunkyPlayer.getUser(p);

        switch (args.length) {
            default:
                if (!args[0].matches("chat")) return;

                if (sbPlayer.getCurrentParty() == null) {
                    sbPlayer.sendMessages(
                            "&9&m-----------------------------",
                            "&cYou're not in a party!",
                            "&9&m-----------------------------"
                    );
                    return;
                }

                StringBuilder message = new StringBuilder();
                for (int i = 1; i != args.length; i++) {
                    message.append(args[i]).append(" ");
                }

                PartyInstance partyInstance = sbPlayer.getCurrentParty();
                for (GodspunkyPlayer member : partyInstance.getMembers()) {
                    member.sendMessage("&9Party &8> &e" + sbPlayer.getPlayer().getDisplayName() + "&f: " + message);
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
                        Player player = Bukkit.getPlayer(playerName);
                        if (player == null) return;

                        GodspunkyPlayer invite = GodspunkyPlayer.getUser(player);

                        PartyManager partyManager = Skyblock.getPartyManager();
                        if (!partyManager.createParty(sbPlayer)) {
                            sbPlayer.sendMessages(
                                    "&9&m-----------------------------",
                                    "&cYou're already in a party!",
                                    "&9&m-----------------------------"
                            );
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
                        Player player = Bukkit.getPlayer(playerName);
                        if (player == null) return;

                        GodspunkyPlayer invite = GodspunkyPlayer.getUser(player);

                        PartyManager partyManager = Skyblock.getPartyManager();
                        partyManager.createParty(sbPlayer);

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

                        String strLeader = args[1];
                        Player leader = Bukkit.getPlayer(strLeader);
                        if (leader == null) return;

                        PartyManager partyManager1 = Skyblock.getPartyManager();
                        if (partyManager1.getPartyFromPlayer(leader.getUniqueId()) == null) return;
                        PartyInstance party = partyManager1.getPartyFromPlayer(leader.getUniqueId());

                        if (!party.hasInvite(sbPlayer)) return;
                        party.addMember(sbPlayer);
                        return;
                    case "kick":
                        String strKick = args[1];
                        Player kickPlayer = Bukkit.getPlayer(strKick);
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
                        for (int i = 1; i != args.length; i++) {
                            message2.append(args[i]).append(" ");
                        }

                        PartyInstance partyInstance2 = sbPlayer.getCurrentParty();
                        for (GodspunkyPlayer member : partyInstance2.getMembers()) {
                            PlayerRank rank = member.rank;
                            String rankPrefix = rank.getPrefix();
                            member.sendMessage("&9Party &8> " + rankPrefix + "&f: " + message2);
                        }
                        return;
                }
        }
    }
}
