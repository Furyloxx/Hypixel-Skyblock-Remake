package me.adarsh.godspunkycore.item.rune;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.Rune;
import me.adarsh.godspunkycore.item.SpecificItemType;
import org.bukkit.ChatColor;

public class PestilenceRune implements Rune {
    @Override
    public String getDisplayName() {
        return ChatColor.DARK_GREEN + "◆ Pestilence Rune";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
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
        return "a8c4811395fbf7f620f05cc3175cef1515aaf775ba04a01045027f0693a90147";
    }
}