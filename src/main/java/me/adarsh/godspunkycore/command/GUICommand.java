package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import me.adarsh.godspunkycore.gui.GUI;
import me.adarsh.godspunkycore.gui.GUIType;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

@CommandParameters(description = "Opens a GUI.", permission = PlayerRank.BETA)
public class GUICommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        if (args.length != 1) throw new CommandArgumentException();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        Player player = sender.getPlayer();
        GUI gui = GUIType.valueOf(args[0].toUpperCase()).getGUI();
        gui.open(player);
    }
}
