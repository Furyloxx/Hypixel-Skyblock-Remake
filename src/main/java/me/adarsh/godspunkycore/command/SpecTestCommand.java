package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import me.adarsh.godspunkycore.gui.GUIType;
import me.adarsh.godspunkycore.user.DoublePlayerStatistic;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


@CommandParameters(description = "Spec test command.", aliases = "test", permission = PlayerRank.ADMIN)
public class SpecTestCommand extends SCommand implements Listener {
    @Override
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        ItemStack stack = player.getItemInHand().clone();
        SItem sItem = SItem.of(SMaterial.ASPECT_OF_THE_DRAGONS);
        sItem.setDisplayName(sItem.getFullName() + " ✪");
        sItem.update();
        player.getInventory().addItem(sItem.getStack());
       player.sendMessage("added star to main hand item");
        System.out.println("SItem " + sItem.toString());
        System.out.println("ItemStack" + stack.toString());


        // ✪
        //GUIType.FARM_MERCHANT.getGUI().open(player);


    }
}
