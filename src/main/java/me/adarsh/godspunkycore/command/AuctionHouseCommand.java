package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.gui.GUIType;

@CommandParameters(description = "Modify your coin amount.", usage = "/<command> <auction uuid/player name>", aliases = "auction,ah")
public class AuctionHouseCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        GUIType.AUCTION_HOUSE.getGUI().open(sender.getPlayer());
    }
}
