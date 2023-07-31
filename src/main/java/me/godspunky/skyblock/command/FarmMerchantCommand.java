package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.gui.GUIType;

@CommandParameters(description = "Open FarmMerchant gui", usage = "/<command> ", aliases = "farmmerchant,fm", permission = PlayerRank.DEFAULT)
public class FarmMerchantCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        GUIType.FARM_MERCHANT.getGUI().open(sender.getPlayer());
    }
}
