package me.adarsh.godspunkycore.command.player;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.gui.GUIType;
import me.adarsh.godspunkycore.util.command.Command;
import me.adarsh.godspunkycore.util.command.annotations.RequiresPlayer;
import me.adarsh.godspunkycore.util.command.annotations.Usage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RequiresPlayer
@Usage(usage = "/bank")
public class BankCommand implements Command {
    @Override
    public void execute(CommandSender sender, String[] args, Skyblock plugin) {
        GUIType.BANKER.getGUI().open((Player) sender);
    }

}
