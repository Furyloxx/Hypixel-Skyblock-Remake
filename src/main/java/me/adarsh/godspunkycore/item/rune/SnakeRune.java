package me.adarsh.godspunkycore.item.rune;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.Rune;
import me.adarsh.godspunkycore.item.SpecificItemType;
import org.bukkit.ChatColor;

public class SnakeRune implements Rune {
    @Override
    public String getDisplayName() {
        return ChatColor.GREEN + "◆ Snake Rune";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.COSMETIC;
    }

    @Override
    public String getURL() {
        return "2c4a65c689b2d36409100a60c2ab8d3d0a67ce94eea3c1f7ac974fd893568b5d";
    }
}