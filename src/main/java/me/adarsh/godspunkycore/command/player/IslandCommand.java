package me.adarsh.godspunkycore.command.player;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.util.command.Command;
import me.adarsh.godspunkycore.util.command.annotations.Description;
import me.adarsh.godspunkycore.util.command.annotations.Permission;
import me.adarsh.godspunkycore.util.command.annotations.RequiresPlayer;
import me.adarsh.godspunkycore.util.command.annotations.Usage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RequiresPlayer
@Usage(usage = "/sb island")
@Description(description = "Teleports you to your island")
@Permission(permission = "skyblock.player")
public class IslandCommand implements Command {
    @Override
    public void execute(CommandSender sender, String[] args, Skyblock plugin) {
        Player player = (Player) sender;
        player.performCommand("sb warp home");
    }
}
