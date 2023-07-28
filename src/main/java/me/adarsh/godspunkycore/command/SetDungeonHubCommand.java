package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import org.bukkit.entity.Player;

@CommandParameters(aliases = "setdhub", permission = PlayerRank.ADMIN)
public class SetDungeonHubCommand extends SCommand{
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
        plugin.getConfig().set("dhub.world", player.getLocation().getWorld().getName());
        plugin.getConfig().set("dhub.x", x);
        plugin.getConfig().set("dhub.y", y);
        plugin.getConfig().set("dhub.z", z);
        plugin.getConfig().set("dhub.yaw", yaw);
        plugin.getConfig().set("dhub.pitch", pitch);

        // Save the changes to the config file
        plugin.saveConfig();

        player.sendMessage("Dungeon Hub location set!");
    }
}
