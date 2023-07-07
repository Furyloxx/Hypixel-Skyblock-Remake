package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.Dungeon.DungeonGenerator;
import me.adarsh.godspunkycore.features.item.SItem;
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
     SItem sItem = SItem.of(player.getItemInHand());
     sItem.addHotBook(3);
        System.out.println(sItem.getHotBooks());


        //GUIType.FARM_MERCHANT.getGUI().open(player);


    }
}
