package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.ranks.PlayerRank;
import org.bukkit.entity.Player;

@CommandParameters(aliases = "sethub", permission = PlayerRank.ADMIN)
public class SetHubCommand extends SCommand{
    @Override
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        // Retrieve the player's location
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();
        float yaw = player.getLocation().getYaw();
        float pitch = player.getLocation().getPitch();

        // Update the config values
        plugin.getConfig().set("hub.world", player.getLocation().getWorld().getName());
        plugin.getConfig().set("hub.x", x);
        plugin.getConfig().set("hub.y", y);
        plugin.getConfig().set("hub.z", z);
        plugin.getConfig().set("hub.yaw", yaw);
        plugin.getConfig().set("hub.pitch", pitch);

        // Save the changes to the config file
        plugin.saveConfig();

        player.sendMessage("Hub location set!");
    }
}
