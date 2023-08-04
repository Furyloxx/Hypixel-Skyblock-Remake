package me.godspunky.skyblock.features.partyandfriends.command;


import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.command.CommandParameters;
import me.godspunky.skyblock.command.CommandSource;
import me.godspunky.skyblock.command.SCommand;
import me.godspunky.skyblock.features.partyandfriends.party.PartyInstance;
import me.godspunky.skyblock.features.ranks.GodspunkyPlayer;
import me.godspunky.skyblock.features.ranks.PlayerRank;

//hmm

@CommandParameters(
        description = "Manage chat settings",
        usage = "/chat {all|party|reply}",
        aliases = "c",
        permission = PlayerRank.DEFAULT
)
public class ChatCommand extends SCommand {


    @Override
    public void run(CommandSource sender, String[] args) {

        GodspunkyPlayer sbPlayer = GodspunkyPlayer.getUser(sender.getPlayer());

        switch (args.length) {
            default:
            case 0:
                sbPlayer.sendMessage("&cInvalid argument(s). Usage: &e/chat {party|reply|skyblock-coop}");
                return;
            case 1:
                switch (args[0]) {
                    default:
                        sbPlayer.sendMessage("&cInvalid argument(s). Usage: &e/chat {all|party|reply|skyblock-coop}");
                        return;
                    case "a":
                    case "all":
                        sbPlayer.sendMessages("&aYou are now in &6ALL &achat.");
                        sbPlayer.currentChat = Skyblock.ChatTypes.ALL_CHAT;
                        return;
                    case "p":
                    case "party":
                        PartyInstance partyInstance = sbPlayer.getCurrentParty();
                        if (partyInstance == null) {
                            sbPlayer.sendMessages("&cYou have to be in a party to use that!");
                            return;
                        }

                        sbPlayer.sendMessages("&aYou are now in &6PARTY &achat.");
                        sbPlayer.currentChat = Skyblock.ChatTypes.PARTY_CHAT;
                        return;
                    case "r":
                    case "reply":
                        sbPlayer.sendMessage("&cThis feature hasn't been implemented yet!");
                }
        }
    }

}
