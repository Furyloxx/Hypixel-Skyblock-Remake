package me.godspunky.skyblock.command;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.Sputnik;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

@CommandParameters(aliases = "hub", permission = PlayerRank.DEFAULT)
public class HubCommand extends SCommand{
    @Override
    public void run(CommandSource sender, String[] args) {
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        Player player = sender.getPlayer();
        int x = plugin.getConfig().getInt("hub.x");
        int y = plugin.getConfig().getInt("hub.y");
        int z = plugin.getConfig().getInt("hub.z");
        int yaw = plugin.getConfig().getInt("hub.yaw");
        int pitch = plugin.getConfig().getInt("hub.pitch");
        World hub = Bukkit.getWorld(plugin.getConfig().getString("hub.world"));
        player.teleport(new Location(hub, x, y, z, yaw, pitch));
    }
}
