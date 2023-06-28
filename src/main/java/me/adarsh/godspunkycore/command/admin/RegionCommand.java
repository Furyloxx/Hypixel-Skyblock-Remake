package me.adarsh.godspunkycore.command.admin;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.region.Region;
import me.adarsh.godspunkycore.features.region.RegionGenerator;
import me.adarsh.godspunkycore.features.region.RegionType;
import me.adarsh.godspunkycore.util.command.Command;
import me.adarsh.godspunkycore.util.command.TrueAlias;
import me.adarsh.godspunkycore.util.command.annotations.Alias;
import me.adarsh.godspunkycore.util.command.annotations.RequiresPlayer;
import me.adarsh.godspunkycore.util.command.annotations.Usage;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;
@RequiresPlayer
@Usage(usage = "/region [create <name> <type> | update <name> [type] | delete <name>]")
@Alias(aliases = "reg")
public class RegionCommand implements Command, TrueAlias<RegionCommand> {
    public static Map<CommandSender, RegionGenerator> REGION_GENERATION_MAP = new HashMap<>();

    @Override
    public void execute(CommandSender sender, String[] args, Skyblock plugin) {
        if (args.length == 3) {
            String name = args[1];
            RegionType type = RegionType.valueOf(args[2].toUpperCase());
            switch (args[0].toLowerCase()) {
                case "create": {
                    if (name.length() > 100) throw new CommandException("Name too long!");
                    if (plugin.regionData.exists(name))
                        throw new CommandException("There is already a region named that!");
                    REGION_GENERATION_MAP.put(sender, new RegionGenerator("create", name, type));
                    sender.sendMessage("Created a region named \"" + name + "\"");
                    sender.sendMessage(ChatColor.DARK_AQUA + "Click the first corner of your region.");
                    return;
                }
            }
        }
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("delete")) {
                String name = args[1];
                Region region = Region.get(name);
                if (region == null) throw new CommandException("There is no region named that!");
                region.delete();
                sender.sendMessage("Deleted region \"" + name + "\" successfully.");
                return;
            }
        }
        if (args.length == 2 || args.length == 3) {
            String name = args[1];
            Region region = Region.get(name);
            if (region == null) throw new CommandException("There is no region named that!");
            RegionType type = region.getType();
            if (args.length == 3)
                type = RegionType.valueOf(args[2].toUpperCase());
            if (!args[0].equalsIgnoreCase("update")) throw new CommandException();
            REGION_GENERATION_MAP.put(sender, new RegionGenerator("update", name, type));
            sender.sendMessage("Updating \"" + name + "\"");
            sender.sendMessage(ChatColor.DARK_AQUA + "Click the first corner of your region.");
            return;
        }
        if (args.length != 0) throw new CommandException();
        StringBuilder result = new StringBuilder()
                .append("Regions");
        for (Region region : Region.getRegions()) {
            result.append("\n")
                    .append(" - ").append(region.getName()).append(" (")
                    .append(region.getType().name().toLowerCase()).append(")");
        }
        sender.sendMessage(result.toString());
    }
}