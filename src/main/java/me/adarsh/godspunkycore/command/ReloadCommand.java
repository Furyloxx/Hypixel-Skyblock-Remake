package me.adarsh.godspunkycore.command;

@CommandParameters(aliases = "sb-reload", permission = "gs.admin")
public class ReloadCommand extends SCommand{
    @Override
    public void run(CommandSource sender, String[] args) {
        plugin.onDisable();
        plugin.onEnable();
    }
}
