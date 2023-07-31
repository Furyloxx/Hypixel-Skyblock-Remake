package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.gui.GUIType;

@CommandParameters(aliases = "lift", permission = PlayerRank.DEFAULT)
public class LiftCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        GUIType.LIFT.getGUI().open(sender.getPlayer());
    }
}
