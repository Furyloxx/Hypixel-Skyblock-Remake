package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import me.adarsh.godspunkycore.gui.GUIType;

@CommandParameters(aliases = "lift", permission = PlayerRank.DEFAULT)
public class LiftCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        GUIType.LIFT.getGUI().open(sender.getPlayer());
    }
}
