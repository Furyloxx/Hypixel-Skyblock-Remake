package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.auction.AuctionItem;
import me.adarsh.godspunkycore.gui.AuctionViewGUI;
import me.adarsh.godspunkycore.gui.GUIType;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

import java.util.List;
import java.util.UUID;

@CommandParameters(description = "Modify your coin amount.", usage = "/<command> <auction uuid/player name>", aliases = "auction,ah")
public class AuctionHouseCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        if (sender instanceof ConsoleCommandSender){
            return;
        }
        GUIType.AUCTION_HOUSE.getGUI().open(sender.getPlayer());
    }
}
