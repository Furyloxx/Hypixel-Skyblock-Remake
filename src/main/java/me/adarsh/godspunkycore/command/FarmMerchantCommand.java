package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.gui.GUIType;

@CommandParameters(description = "Open FarmMerchant gui", usage = "/<command> ", aliases = "farmmerchant,fm")
public class FarmMerchantCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        GUIType.FARM_MERCHANT.getGUI().open(sender.getPlayer());
    }
}
