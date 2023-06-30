package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import me.adarsh.godspunkycore.features.ranks.GodspunkyPlayer;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public abstract class SCommand implements CommandExecutor, TabCompleter {
    public static final String COMMAND_SUFFIX = "Command";
    protected static final Skyblock plugin = Skyblock.getPlugin();

    private CommandParameters params;
    private String name;
    private String description;
    private String usage;
    private List<String> aliases;
    private PlayerRank permission;
    private SECommand command;

    private CommandSource sender;

    protected SCommand() {
        this.params = this.getClass().getAnnotation(CommandParameters.class);
        this.name = this.getClass().getSimpleName().replace(COMMAND_SUFFIX, "").toLowerCase();
        this.description = this.params.description();
        this.usage = this.params.usage();
        this.aliases = Arrays.asList(this.params.aliases().split(","));
        this.permission = this.params.permission();
        this.command = new SECommand(this);
    }

    public abstract void run(CommandSource sender, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }

    public void register() {
        plugin.commandMap.register("", this.command);
    }

    private static class SECommand extends Command {
        private final SCommand sc;

        public SECommand(SCommand xc) {
            super(xc.name, xc.description, xc.usage, xc.aliases);
            this.setPermissionMessage(ChatColor.RED + "No permission. You need \"" + xc.permission + "\"");
            this.sc = xc;
        }

        @Override
        public boolean execute(CommandSender sender, String commandLabel, String[] args) {
            sc.sender = new CommandSource(sender);
            try {
                sc.checkPermission(sc.permission); // Check if player has the required rank
                sc.run(sc.sender, args);
                return true;
            } catch (CommandFailException | CommandPermissionException | PlayerNotFoundException ex) {
                sender.sendMessage(ex.getMessage());
                return true;
            } catch (CommandArgumentException ex) {
                return false;
            } catch (Exception ex) {
                sender.sendMessage(ChatColor.RED + "Error: " + ex.getMessage());
                ex.printStackTrace();
                return true;
            }
        }


        @Override
        public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
            List<String> tc = sc.onTabComplete(sender, this, alias, args);
            if (tc != null)
                return tc;
            return SUtil.getPlayerNameList();
        }
    }

    public void send(String message, CommandSource sender) {
        sender.send(ChatColor.GRAY + message);
    }

    public void send(String message) {
        send(message, sender);
    }

    public void send(String message, Player player) {
        player.sendMessage(ChatColor.GRAY + message);
    }

    public void checkPermission(PlayerRank requiredRank) {
        PlayerRank playerRank = getPlayerRank(sender.getPlayer());
        if (!playerRank.isAboveOrEqual(requiredRank)) {
            throw new CommandPermissionException(requiredRank);
        }
    }



    public Player getNonNullPlayer(String name) {
        Player player = Bukkit.getPlayer(name);
        if (player == null)
            throw new PlayerNotFoundException();
        return player;
    }

    public PlayerRank getPlayerRank(Player player) {
        GodspunkyPlayer godspunkyPlayer = GodspunkyPlayer.getUser(player);
        if (godspunkyPlayer != null)
            return godspunkyPlayer.rank;
        return PlayerRank.DEFAULT;
    }

}