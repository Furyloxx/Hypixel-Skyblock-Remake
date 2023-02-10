package me.adarsh.godspunkycore.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandParameters(description = "The main command for Spectaculation.", aliases = "spt")
public class SpectaculationCommand extends SCommand
{
    @Override
    public void run(CommandSource sender, String[] args)
    {
        Player player = sender.getPlayer();
        player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "GodSpunky Core");
    }
}