package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import me.adarsh.godspunkycore.gui.GUIType;

@CommandParameters(aliases = "bank", permission = PlayerRank.DEFAULT)
public class BankCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        GUIType.BANKER.getGUI().open(sender.getPlayer());
    }
}
