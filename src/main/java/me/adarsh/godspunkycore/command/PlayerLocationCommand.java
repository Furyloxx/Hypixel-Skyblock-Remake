package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandParameters(aliases = "loc", permission = PlayerRank.ADMIN)
public class PlayerLocationCommand extends SCommand{
    @Override
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        // Retrieve the player's location
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();
        float yaw = player.getLocation().getYaw();
        float pitch = player.getLocation().getPitch();

        player.sendMessage(ChatColor.GRAY + "World: " + ChatColor.GREEN + player.getLocation().getWorld().getName());
        player.sendMessage(ChatColor.GRAY+"X: "+ChatColor.GREEN+x);
        player.sendMessage(ChatColor.GRAY+"Y: "+ChatColor.GREEN+y);
        player.sendMessage(ChatColor.GRAY+"Z: "+ChatColor.GREEN+z);
        player.sendMessage(ChatColor.GRAY+"Yaw: "+ChatColor.GREEN+yaw);
        player.sendMessage(ChatColor.GRAY+"Pitch: "+ChatColor.GREEN+pitch);

    }
}