package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.ranks.PlayerRank;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta


@CommandParameters(description = "Spec test command.", aliases = "test", permission = PlayerRank.ADMIN)
public class SpecTestCommand extends SCommand implements Listener {
    ItemStack book = new ItemStack(org.bukkit.Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();

        // Set book title and author
        meta.setTitle(ChatColor.GOLD + "SkyBlock Animation");
        meta.setAuthor("The Hypixel Team");

        // Add pages to the book
        meta.addPage(
                ChatColor.BLACK + "SkyBlock Animation\n\n" +
                ChatColor.BLACK + "The Hypixel Team has\n" +
                ChatColor.BLACK + "released a new\n" +
                ChatColor.BLACK + "animated video for\n" +
                ChatColor.BLACK + "SkyBlock! Your\n" +
                ChatColor.BLACK + "Adventure Awaits!\n\n" +
                ChatColor.BLACK + ChatColor.BOLD + "CLICK TO WATCH\n" +
                ChatColor.BLUE + "https://youtu.be/FTOaoMTWH4E?si=dg0zeu5GWttZ9jUi"
        );

        // Apply the book meta
        book.setItemMeta(meta);

        // Open the book for the player
        player.openBook(book);
}