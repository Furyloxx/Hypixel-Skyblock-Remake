package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.launchpads.LaunchPadHandler;
import me.godspunky.skyblock.features.launchpads.PadGenerator;
import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.features.region.RegionGenerator;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

@CommandParameters(aliases = "setpad", permission = PlayerRank.ADMIN)
public class SetLaunchPad extends SCommand {
    public static Map<Player, PadGenerator> PAD_GENERATION_MAP = new HashMap<>();


    @Override
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        PAD_GENERATION_MAP.put(player , new PadGenerator(args[0] , args[1]));
        send(ChatColor.DARK_AQUA + "Click at the first location of pad");
    }
}
