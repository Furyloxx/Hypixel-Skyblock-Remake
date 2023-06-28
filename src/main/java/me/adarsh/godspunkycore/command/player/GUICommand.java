package me.adarsh.godspunkycore.command.player;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.gui.GUI;
import me.adarsh.godspunkycore.gui.GUIType;
import me.adarsh.godspunkycore.util.command.Command;
import me.adarsh.godspunkycore.util.command.annotations.RequiresPlayer;
import me.adarsh.godspunkycore.util.command.annotations.Usage;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

@RequiresPlayer
@Usage(usage = "/gui open <name>")
public class GUICommand implements Command {
    @Override
    public void execute(CommandSender sender, String[] args, Skyblock plugin) {
        if (args.length != 1) throw new CommandException();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandException("Console senders cannot use this command!");
        Player player = (Player) sender;
        GUI gui = GUIType.valueOf(args[0].toUpperCase()).getGUI();
        gui.open(player);
    }
}
