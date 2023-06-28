package me.adarsh.godspunkycore.command;

@CommandParameters(aliases = "sb", permission = "gs.admin")
public class ReloadCommand extends SCommand{
    @Override
    public void run(CommandSource sender, String[] args) {

        if (args.length == 1){
            switch (args[0].toLowerCase()) {
                case "reload": {
                    plugin.onDisable();
                    plugin.onEnable();
                    sender.send(plugin.getPrefix() + "Successfully reloaded Skyblock");
                }
            }
        }
    }
}
