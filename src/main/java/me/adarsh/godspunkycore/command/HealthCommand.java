package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

@CommandParameters(aliases = "health", permission = PlayerRank.ADMIN)
public class HealthCommand extends SCommand{

    private PlayerStatistics statistics;
    private PlayerBoostStatistics boostStatistics;

    @Override
    public void run(CommandSource sender, String[] args) {
        if (args.length != 0 && args.length != 2) throw new CommandArgumentException();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");

        Player player = sender.getPlayer();
        double health = Double.parseDouble(args[1]);
        switch (args[0].toLowerCase()) {
            case "add": {
                statistics.getMaxHealth().add(1, health);
            }
        }
    }
}
