package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.gui.GUIType;

@CommandParameters(aliases = "bank", permission = PlayerRank.DEFAULT)
public class BankCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        GUIType.BANKER.getGUI().open(sender.getPlayer());
    }
}
