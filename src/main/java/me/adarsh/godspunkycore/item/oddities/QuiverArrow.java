package me.adarsh.godspunkycore.item.oddities;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.MaterialStatistics;
import me.adarsh.godspunkycore.item.Rarity;
import org.bukkit.ChatColor;

public class QuiverArrow implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return ChatColor.DARK_GRAY + "Quiver Arrow";
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
    public String getLore() {
        return "This item is in your inventory because you are holding your bow currently. Switch your held item to see the item that was here before.";
    }

    @Override
    public boolean displayRarity() {
        return false;
    }
}