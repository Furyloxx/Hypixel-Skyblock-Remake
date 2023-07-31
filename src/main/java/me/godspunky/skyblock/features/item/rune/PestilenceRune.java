package me.godspunky.skyblock.features.item.rune;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.Rune;
import me.godspunky.skyblock.features.item.SpecificItemType;
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