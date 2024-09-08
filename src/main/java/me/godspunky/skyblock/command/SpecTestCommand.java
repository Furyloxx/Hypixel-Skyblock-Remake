package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.ranks.PlayerRank;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import me.godspunky.skyblock.npc.*;


@CommandParameters(description = "Spec test command.", aliases = "test", permission = PlayerRank.ADMIN)
public class SpecTestCommand extends SCommand
{
    @Override
    public void run(CommandSource sender, String[] args)
    {
        for (SkyblockNPC npc : SkyblockNPCManager.getNPCS()){
            npc.showTo(sender.getPlayer());
            send("Loading npcs");
        }

    }
}