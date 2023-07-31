package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.gui.GUIType;

@CommandParameters(description = "Modify your coin amount.", usage = "/<command> <auction uuid/player name>", aliases = "auction,ah", permission = PlayerRank.DEFAULT)
public class AuctionHouseCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        GUIType.AUCTION_HOUSE.getGUI().open(sender.getPlayer());
    }
}
