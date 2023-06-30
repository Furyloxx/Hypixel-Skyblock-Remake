package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import org.bukkit.ChatColor;

public class CommandPermissionException extends RuntimeException {

    public CommandPermissionException(PlayerRank permission) {
        super(ChatColor.RED + "No permission. You need \"" + permission.getPrefix().replace("[", "").replace("]", "") + "\"");
    }
}