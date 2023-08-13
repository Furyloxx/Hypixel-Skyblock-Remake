package me.godspunky.skyblock.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.Sputnik;
import org.bukkit.entity.Player;

@CommandParameters(description = "Modify your coin amount.", usage = "", aliases = "ss", permission = PlayerRank.DEFAULT)
public class ServerCommand extends SCommand {
    public Map<UUID, List<String>> servers = new HashMap<>();

    public void run(CommandSource sender, String[] args) {
        UUID runUUID = UUID.randomUUID();
        if (Skyblock.getPlugin().getBc() == null) {
            send(Sputnik.trans("&cThis is not a BungeeCord based server!"));
            return;
        }
        if (sender.getPlayer() == null) {
            send(Sputnik.trans("&cConsole Sender cannot execute Proxy commands!"));
            return;
        }
        Player p = sender.getPlayer();
        if (args.length != 1) {
            send(Sputnik.trans("&cCorrect Command Usage: /ss <server name>"));
            return;
        }
        String targetServer = args[0];
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
            user.save();

            SUtil.delay(() -> {
                Skyblock.getPlugin().getBc().connect(p, targetServer);
            }, 8L);
        });
    }
}