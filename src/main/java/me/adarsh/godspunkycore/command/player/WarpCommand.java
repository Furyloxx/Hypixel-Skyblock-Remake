package me.adarsh.godspunkycore.command.player;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.SkyblockPlayer;
import me.adarsh.godspunkycore.features.islands.IslandManager;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.command.Command;
import me.adarsh.godspunkycore.util.command.TrueAlias;
import me.adarsh.godspunkycore.util.command.annotations.Description;
import me.adarsh.godspunkycore.util.command.annotations.Permission;
import me.adarsh.godspunkycore.util.command.annotations.RequiresPlayer;
import me.adarsh.godspunkycore.util.command.annotations.Usage;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

@RequiresPlayer
@Usage(usage = "/sb warp <name>")
@Description(description = "Sends you to a location")
@Permission(permission = "skyblock.player")
public class WarpCommand implements Command, TrueAlias<WarpCommand> {

    @Override
    public void execute(Player player, String[] args, Skyblock plugin) {
        if (args.length == 0) {
            player.sendMessage("idk");
            return;
        }

        String warpName = args[0];

        HashMap<String, Location> warps = new HashMap<>();
        warps.put("hub", new Location(Skyblock.getSkyblockWorld(), -2 , 70,  -84,  -180, 0));
        warps.put("home", new Location(IslandManager.getIsland(player), 0, 100, 0));

        if (warps.containsKey(warpName)) {
            player.teleport(warps.get(warpName));

            return;
        }

        // Operator Warps
        if (player.isOp()) {
            player.teleport(SUtil.getSpawnLocation(warpName));
        }
    }
}
