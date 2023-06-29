package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.enums.Stats;
import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

@CommandParameters(description = "command to change stats.", aliases = "stats", permission = PlayerRank.ADMIN)
public class ChangeStatsCommand extends SCommand implements Listener {

    @Override
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
         changeStat(Stats.valueOf(args[0]) , player , Double.valueOf(args[1]));
    }

    public void changeStat(Stats stats , Player player , Double value){
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId());
        switch (stats) {

            case health:
                statistics.getMaxHealth().setValue(value);
                statistics.getMaxHealth().addAll();
                break;
            case defense:
                statistics.getDefense().setValue(value);
                statistics.getDefense().addAll();
                break;
            case mana:
                statistics.getIntelligence().setValue(value);
                statistics.getIntelligence().addAll();
                break;
            case crit_damage:
                statistics.getCritDamage().setValue(value);
                statistics.getCritDamage().addAll();
                break;
            case crit_chance:
                statistics.getCritChance().setValue(value);
                statistics.getCritChance().addAll();
               break;
            case speed:
                statistics.getSpeed().setValue(value);
                statistics.getSpeed().addAll();
                break;
            case strength:
                statistics.getStrength().setValue(value);
                statistics.getStrength().addAll();
            default:
                player.sendMessage("invalid stat");
        }
    }
}
