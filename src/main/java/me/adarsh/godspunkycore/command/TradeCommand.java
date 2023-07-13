package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

@CommandParameters(description = "Trade command.", aliases = "trade", permission = PlayerRank.DEFAULT)
public class TradeCommand extends SCommand {
    public void run(CommandSource sender, String[] args) {
        if (sender instanceof org.bukkit.command.ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        Player player = sender.getPlayer();
        if (args.length != 1) {
            send(ChatColor.RED+"&cWrong usage of command! It must be /trade <PLAYER>");
            return;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            send(ChatColor.translateAlternateColorCodes('&',"&cCannot find player named &f" + args[0] + "&c, maybe they've gone offline?"));
            return;
        }
        player.sendMessage(ChatColor.RED+"Coming Soon!");
        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT,1.0f,1.0f);
    }
}

