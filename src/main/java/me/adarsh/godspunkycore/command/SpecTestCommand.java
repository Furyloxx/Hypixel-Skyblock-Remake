package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.gui.GUIType;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


@CommandParameters(description = "Spec test command.", aliases = "test")
public class SpecTestCommand extends SCommand implements Listener {
    @Override
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        GUIType.Mine_MERCHANT.getGUI().open(player);

    }
}












