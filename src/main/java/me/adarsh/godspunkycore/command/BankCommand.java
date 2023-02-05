package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.gui.GUIType;

@CommandParameters(aliases = "bank")
public class BankCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        GUIType.BANKER.getGUI().open(sender.getPlayer());
    }
}
