package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.enums.Category;
import me.adarsh.godspunkycore.features.bazaar.BazaarGui;
import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


@CommandParameters(description = "Spec test command.", aliases = "test", permission = PlayerRank.ADMIN)
public class SpecTestCommand extends SCommand implements Listener {
    @Override
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        BazaarGui gui = new BazaarGui();
        gui.createGui(player , Category.FarmingCategory);


        //GUIType.FARM_MERCHANT.getGUI().open(player);


    }
}
