package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.potion.ActivePotionEffect;
import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

@CommandParameters(description = "Get your current active potion effects.", aliases = "seff", permission = PlayerRank.ADMIN)
public class SpecEffectsCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        if (args.length > 1) throw new CommandArgumentException();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        if (args.length == 1 && args[0].equalsIgnoreCase("clear")) {
            sender.getUser().clearPotionEffects();
            send("Cleared active effects.");
            return;
        }
        send("Current active effects:");
        for (ActivePotionEffect effect : sender.getUser().getEffects())
            send(" - " + effect.getEffect().getType().getName() + " " + SUtil.toRomanNumeral(effect.getEffect().getLevel()) + ChatColor.GRAY + " (" + effect.getRemainingDisplay() + ")");
    }
}
