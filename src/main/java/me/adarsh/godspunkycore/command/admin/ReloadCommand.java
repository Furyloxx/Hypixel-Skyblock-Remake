package me.adarsh.godspunkycore.command.admin;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.util.command.Command;
import me.adarsh.godspunkycore.util.command.annotations.Description;
import me.adarsh.godspunkycore.util.command.annotations.Permission;
import me.adarsh.godspunkycore.util.command.annotations.Usage;
import org.bukkit.command.CommandSender;

@Usage(usage = "/sb reload")
@Description(description = "Reloads Skyblock")
@Permission(permission = "skyblock.admin")
public class ReloadCommand implements Command {

    @Override
    public void execute(CommandSender sender, String[] args, Skyblock plugin) {
        plugin.onDisable();

        plugin.onEnable();

        sender.sendMessage(plugin.getPrefix() + "Successfully reloaded Skyblock");
    }
}