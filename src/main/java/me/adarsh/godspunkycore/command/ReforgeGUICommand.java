package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.gui.GUIType;

@CommandParameters(description = "Open Reforge GUI", usage = "/<command> ", aliases = "reforge,blacksmith")
public class ReforgeGUICommand extends SCommand{
    @Override
    public void run(CommandSource sender, String[] args) {
        GUIType.REFORGE_ANVIL.getGUI().open(sender.getPlayer());
    }
}
