package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
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
        if (!getPlayerRank(player).isAboveOrEqual(PlayerRank.DEFAULT)) {
            player.sendMessage(ChatColor.RED + "You need a higher rank to use this command.");
            return;
        }
        int x = plugin.getConfig().getInt("hub.x");
        int y = plugin.getConfig().getInt("hub.y");
        int z = plugin.getConfig().getInt("hub.z");
        int yaw = plugin.getConfig().getInt("hub.yaw");
        int pitch = plugin.getConfig().getInt("hub.pitch");
        World hub = Bukkit.getWorld(plugin.getConfig().getString("hub.world"));
        player.teleport(new Location(hub, x, y, z, yaw, pitch));
    }
}
