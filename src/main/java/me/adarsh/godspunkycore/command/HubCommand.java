package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

@CommandParameters(aliases = "hub", permission = PlayerRank.DEFAULT)
public class HubCommand extends SCommand{
    @Override
    public void run(CommandSource sender, String[] args) {
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        Player player = sender.getPlayer();
        if (player.getWorld().getName().equals(plugin.config.getString("hub_world"))){
            player.sendMessage(plugin.getPrefix()+"You are already on hub.");
            return;
        }
        World hub = Bukkit.getWorld(!plugin.config.getString("hub_world").isEmpty() ? plugin.config.getString("hub_world") : "hub");
        player.teleport(hub.getSpawnLocation());
    }
}
