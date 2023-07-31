package me.godspunky.skyblock.command;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.ranks.PlayerRank;

@CommandParameters(aliases = "sb", permission = PlayerRank.ADMIN)
public class ReloadCommand extends SCommand{
    @Override
    public void run(CommandSource sender, String[] args) {

        if (args.length == 1){
            switch (args[0].toLowerCase()) {
                case "reload": {
                    Skyblock.getPlugin().onDisable();
                    Skyblock.getPlugin().onEnable();
                    sender.send(Skyblock.getPlugin().getPrefix() + "Successfully reloaded Skyblock");
                }
            }
        }
    }
}
