package me.adarsh.godspunkycore.command.player;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.util.command.Command;
import me.adarsh.godspunkycore.util.command.TrueAlias;
import me.adarsh.godspunkycore.util.command.annotations.Description;
import me.adarsh.godspunkycore.util.command.annotations.RequiresPlayer;
import me.adarsh.godspunkycore.util.command.annotations.Usage;
import org.bukkit.entity.Player;

@RequiresPlayer
@Usage(usage = "/sb hub")
@Description(description = "Teleports you to the hub")
public class HubCommand implements Command, TrueAlias<HubCommand> {

    @Override
    public void execute(Player player, String[] args, Skyblock plugin) {
        player.performCommand("sb warp hub");
    }
}