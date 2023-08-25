package me.godspunky.skyblock.command;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.Sputnik;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

@CommandParameters(aliases = "hub", permission = PlayerRank.DEFAULT)
public class HubCommand extends SCommand{
    @Override
    public void run(CommandSource sender, String[] args) {
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        Player player = sender.getPlayer();
        if (!getPlayerRank(player).isAboveOrEqual(PlayerRank.DEFAULT)) {
            player.sendMessage(ChatColor.RED + "You need a higher rank to use this command.");
            return;
        }
        Player p = sender.getPlayer();
        String targetServer = "hub-1";
        Skyblock.getPlugin().getBc().getServers().thenAcceptAsync(servers -> {
            boolean serverExists = servers.contains(targetServer);

            if (!serverExists) {
                String availableServers = String.join(", ", servers);
                send(Sputnik.trans("&cThat server doesn't exist! Available servers: " + availableServers));
                return;
            }

            String currentServer = Skyblock.getPlugin().getServerName();
            if (currentServer.equalsIgnoreCase(targetServer)) {
                send(Sputnik.trans("&cYou're already on " + targetServer));
                return;
            }

            send(Sputnik.trans("&7Hooking up request..."));
            send(Sputnik.trans("&7Sending you to " + targetServer + "..."));

            User user = User.getUser(p.getUniqueId());
            user.syncSavingData();

            SUtil.delay(() -> {
                Skyblock.getPlugin().getBc().connect(p, targetServer);
            }, 8L);
        });
    }
}
