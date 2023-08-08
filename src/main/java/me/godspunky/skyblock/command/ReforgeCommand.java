package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.features.reforge.Reforge;
import me.godspunky.skyblock.features.reforge.ReforgeType;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandParameters(description = "Reforge an item from Spec.", aliases = "reforge", permission = PlayerRank.DEFAULT)
public class ReforgeCommand extends SCommand {
    public void run(CommandSource sender, String[] args) {
        if (args.length != 1)
            throw new CommandArgumentException();
        if (sender instanceof org.bukkit.command.ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        Player player = sender.getPlayer();
        ItemStack stack = player.getInventory().getItemInHand();
        if (stack == null)
            throw new CommandFailException(ChatColor.RED + "You don't have anything in your hand!");
        SItem sItem = SItem.find(stack);
        if (sItem == null)
            throw new CommandFailException(ChatColor.RED + "That item is un-reforgeable!");
        Reforge reforge = ReforgeType.getReforgeType(args[0]).getReforge();
        sItem.setReforge(reforge);
        send(ChatColor.GREEN + "Your " + sItem.getType().getDisplayName(sItem.getVariant()) + " now has " + reforge.getName() + " on it.");
    }
}
