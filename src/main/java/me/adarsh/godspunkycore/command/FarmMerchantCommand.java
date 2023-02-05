package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.gui.GUIType;
import org.bukkit.command.ConsoleCommandSender;

@CommandParameters(description = "Open FarmMerchant gui", usage = "/<command> ", aliases = "farmmerchant,fm")
public class FarmMerchantCommand extends SCommand{
    @Override
    public void run(CommandSource sender, String[] args) {
        if (sender instanceof ConsoleCommandSender){
            return false;
        }
        GUIType.FARM_MERCHANT.getGUI().open(sender.getPlayer());
        return false;
    }
}
