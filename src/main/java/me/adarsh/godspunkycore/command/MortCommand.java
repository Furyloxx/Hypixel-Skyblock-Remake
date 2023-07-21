package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import me.adarsh.godspunkycore.features.gui.GUIType;

@CommandParameters(aliases = "mort", permission = PlayerRank.DEFAULT)
public class MortCommand extends SCommand{
    public void run(CommandSource sender, String[] args) {
        GUIType.CATACOMB.getGUI().open(sender.getPlayer());
    }
}
