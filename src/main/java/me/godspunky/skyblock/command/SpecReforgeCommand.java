package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.features.reforge.Reforge;
import me.godspunky.skyblock.features.reforge.ReforgeType;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandParameters(description = "Reforge an item from Spec.", aliases = "sref", permission = PlayerRank.ADMIN)
public class SpecReforgeCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        if (args.length != 1) throw new CommandArgumentException();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        Player player = sender.getPlayer();
        ItemStack stack = player.getInventory().getItemInHand();
        if (stack == null) throw new CommandFailException("You don't have anything in your hand!");
        SItem sItem = SItem.find(stack);
        if (sItem == null) throw new CommandFailException("That item is not from Spec!");
        Reforge reforge = ReforgeType.getReforgeType(args[0]).getReforge();
        sItem.setReforge(reforge);
        send("Your " + sItem.getType().getDisplayName(sItem.getVariant()) + " now has " + reforge.getName() + " on it.");
    }
}
