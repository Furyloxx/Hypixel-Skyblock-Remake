package me.adarsh.godspunkycore.features.item.hoe.vanilla;

import me.adarsh.godspunkycore.features.item.*;
import org.bukkit.ChatColor;

public class RookieHoe implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Rookie Hoe";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.TOOL;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.HOE;
    }

    @Override
    public String getLore(){
        return ChatColor.GRAY + "Crops broken with this hoe have a" + ChatColor.GREEN + "50%" +
    ChatColor.GRAY + "chance to drop a seed.";
    }
}