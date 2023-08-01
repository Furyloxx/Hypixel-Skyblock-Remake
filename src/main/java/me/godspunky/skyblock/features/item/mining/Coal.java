package me.godspunky.skyblock.features.item.mining;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import org.bukkit.ChatColor;

public class Coal implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Coal";
    }

    @Override
    public String getLore(){
        return ChatColor.GRAY+"increases the speed of your minion by"+ChatColor.GREEN+" 5% "+ChatColor.GRAY+" for 30 minutes!";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public long getPrice() {
        return 100L;
    }
}
