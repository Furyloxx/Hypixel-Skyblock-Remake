package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.gui.GUIType;

@CommandParameters(description = "Open Reforge GUI", usage = "/<command> ", aliases = "reforge,blacksmith", permission = PlayerRank.DEFAULT)
public class ReforgeGUICommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        GUIType.REFORGE_ANVIL.getGUI().open(sender.getPlayer());
    }
}
