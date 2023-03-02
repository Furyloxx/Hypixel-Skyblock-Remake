package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.gui.GUIType;

@CommandParameters(aliases = "lift")
public class LiftCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        GUIType.LIFT.getGUI().open(sender.getPlayer());
    }
}
