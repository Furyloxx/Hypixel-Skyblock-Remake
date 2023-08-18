package me.godspunky.skyblock.command;


import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.user.PlayerUtils;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.Sputnik;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;


@CommandParameters(description = "go to or create your island", aliases = "is", permission = PlayerRank.DEFAULT)
public class IslandCommand extends SCommand {

    @Override
    public void run(CommandSource sender, String[] args) {
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        Player p = sender.getPlayer();
        UUID runUUID = UUID.randomUUID();
        String targetServer = "is-1";
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

            SUtil.delay(() -> Skyblock.getPlugin().getBc().connect(p, targetServer), 8L);
        });
    }
}

