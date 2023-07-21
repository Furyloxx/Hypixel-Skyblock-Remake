package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CommandParameters(description = "Hidden command.", aliases = "attc", permission = PlayerRank.DEFAULT)
public class AccessTimedCommand extends SCommand
{
    public static final List<UUID> KEYS;

    @Override
    public void run(final CommandSource sender, final String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            throw new CommandFailException("Console senders cannot use this command!");
        }
        final Player p = sender.getPlayer();
        if (args.length != 2) {
            this.send(ChatColor.RED + "System Command! You don't have access to it.");
            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, -4.0f);
            return;
        }
        if (!AccessTimedCommand.KEYS.contains(UUID.fromString(args[0]))) {
            this.send(ChatColor.RED + "The requested action is no longer available!");
            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, -4.0f);
            return;
        }
        p.chat("/trade " + args[1]);
        AccessTimedCommand.KEYS.remove(UUID.fromString(args[0]));
    }

    static {
        KEYS = new ArrayList<UUID>();
    }
}
