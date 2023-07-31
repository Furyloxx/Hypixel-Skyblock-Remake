package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.ranks.PlayerRank;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


@CommandParameters(description = "Spec test command.", aliases = "test", permission = PlayerRank.ADMIN)
public class SpecTestCommand extends SCommand implements Listener {
    @Override
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");

        player.sendMessage(player.getItemInHand().getItemMeta().getDisplayName());


    }
}
