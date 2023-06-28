package me.adarsh.godspunkycore.command.admin;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.gui.ItemBrowserGUI;
import me.adarsh.godspunkycore.util.command.Command;
import me.adarsh.godspunkycore.util.command.annotations.Alias;
import me.adarsh.godspunkycore.util.command.annotations.Permission;
import me.adarsh.godspunkycore.util.command.annotations.RequiresPlayer;
import me.adarsh.godspunkycore.util.command.annotations.Usage;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
@RequiresPlayer
@Alias(aliases = "ib")
@Usage(usage = "/sb itembrowser")
@Permission(permission = "skyblock.admin")
public class ItemBrowseCommand implements Command {
    @Override
    public void execute(CommandSender sender, String[] args, Skyblock plugin) {
        if (sender instanceof ConsoleCommandSender)
            throw new CommandException("Console senders cannot use this command!");
        Player player = (Player) sender;
        String query = "";
        if (args.length >= 1)
            query = StringUtils.join(args);
        new ItemBrowserGUI(query).open(player);
    }
}
