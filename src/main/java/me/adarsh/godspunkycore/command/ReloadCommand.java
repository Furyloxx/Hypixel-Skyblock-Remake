package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.ranks.PlayerRank;

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
