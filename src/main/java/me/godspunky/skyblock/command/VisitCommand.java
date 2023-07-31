package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.ranks.PlayerRank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

@CommandParameters(description = "Visit command.", aliases = "visit", permission = PlayerRank.DEFAULT)
public class VisitCommand extends SCommand implements Listener {
    @Override
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        String target = args[0];
        Inventory menu = Bukkit.createInventory(null, 36, "Visit " + target);
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) SkullType.PLAYER.ordinal());
        SkullMeta itemMeta = (SkullMeta) skull.getItemMeta();
        itemMeta.setOwner(target);
        List<String> lore = new ArrayList<>();
        itemMeta.setDisplayName(ChatColor.GREEN + "Visit player island");
        lore.add(ChatColor.GRAY + "Players:");
        lore.add(ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + target);
        lore.add(" ");
        lore.add(ChatColor.GRAY + "Profile: " + ChatColor.YELLOW + "Strawberry");
        lore.add(" ");
        lore.add(ChatColor.GRAY + "Players: " + ChatColor.GREEN + target);
        lore.add(ChatColor.GRAY + "Server: " + ChatColor.DARK_GRAY + "Island_" + target);
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click to visit!");
        itemMeta.setLore(lore);
        skull.setItemMeta(itemMeta);
        menu.setItem(13, skull);
        player.openInventory(menu);
    }
}

