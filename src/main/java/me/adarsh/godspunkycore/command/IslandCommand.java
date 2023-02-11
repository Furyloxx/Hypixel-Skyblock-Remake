package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.user.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.io.File;

@CommandParameters(description = "go to or create your island", aliases = "is")
public class IslandCommand extends SCommand {
    public static final String ISLAND_PREFIX = "island-";

    @Override
    public void run(CommandSource sender, String[] args) {
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        Player player = sender.getPlayer();
    }
}
