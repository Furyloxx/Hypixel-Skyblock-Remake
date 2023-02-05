package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.gui.GUIType;
import org.bukkit.command.ConsoleCommandSender;

@CommandParameters(aliases = "lift")
public class LiftCommand extends SCommand{
    @Override
    public void run(CommandSource sender, String[] args) {
        if (sender instanceof ConsoleCommandSender){
            return false;
        }
        GUIType.LIFT.getGUI().open(sender.getPlayer());
        return false;
    }
}
