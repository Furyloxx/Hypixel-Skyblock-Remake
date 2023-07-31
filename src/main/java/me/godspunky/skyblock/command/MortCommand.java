package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.gui.GUIType;

@CommandParameters(aliases = "mort", permission = PlayerRank.DEFAULT)
public class MortCommand extends SCommand{
    public void run(CommandSource sender, String[] args) {
        GUIType.CATACOMB.getGUI().open(sender.getPlayer());
    }
}
