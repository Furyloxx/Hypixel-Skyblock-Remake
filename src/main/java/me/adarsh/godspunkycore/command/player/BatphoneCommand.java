package me.adarsh.godspunkycore.command.player;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.gui.GUI;
import me.adarsh.godspunkycore.gui.GUIType;
import me.adarsh.godspunkycore.features.item.oddities.MaddoxBatphone;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.command.Command;
import me.adarsh.godspunkycore.util.command.annotations.Description;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Description(description = "Hidden command for Maddox Batphone.")
public class BatphoneCommand implements Command {
    public static final UUID ACCESS_KEY = UUID.randomUUID();
    public static final List<String> KEYS = new ArrayList<>();

    @Override
    public void execute(CommandSender sender, String[] args, Skyblock plugin) {
        if (sender instanceof ConsoleCommandSender)
            throw new CommandException("Console senders cannot use this command!");
        if (!args[0].equals(ACCESS_KEY.toString()))
            return;
        if (!KEYS.contains(args[1]))
            throw new CommandException(ChatColor.RED + "✆ It's too late now, the phone line is off! Call again!");
        Player player = (Player)sender;
        MaddoxBatphone.CALL_COOLDOWN.add(player.getUniqueId());
        SUtil.delay(() -> MaddoxBatphone.CALL_COOLDOWN.remove(player.getUniqueId()), 20 * 20);
        GUI gui = GUIType.SLAYER.getGUI();
        gui.open(player);
    }
}