package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.island.IslandManager;
import org.bukkit.*;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

@CommandParameters(description = "Spec test command.", aliases = "test")
public class SpecTestCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        if (args.length == 0) {
            player.sendMessage("Plz input Player Name");
            return;
        }

        OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
        if (target.hasPlayedBefore()) {
            Inventory menu = Bukkit.createInventory(null, 36, "Visit " + target.getName());
            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) SkullType.PLAYER.ordinal());
            SkullMeta itemMeta = (SkullMeta) skull.getItemMeta();
            itemMeta.setOwner(target.getName());
            List<String> lore = new ArrayList<>();
            itemMeta.setDisplayName(ChatColor.GREEN + "Visit player island");
            lore.add(ChatColor.GRAY + "Players:");
            lore.add(ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + target.getName());
            lore.add(" ");
            lore.add(ChatColor.GRAY + "Profile: " + ChatColor.YELLOW + "Strawberry");
            lore.add(" ");
            lore.add(ChatColor.GRAY + "Players: " + ChatColor.GREEN + target.getName());
            lore.add(ChatColor.GRAY + "Server: " + ChatColor.DARK_GRAY + "Island_" + target.getName());
            lore.add(" ");
            lore.add(ChatColor.YELLOW + "Click to visit!");
            itemMeta.setLore(lore);
            skull.setItemMeta(itemMeta);

            menu.setItem(13, skull);

            player.openInventory(menu);
        }
    }
}



