package me.adarsh.godspunkycore.features.item.rune;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.Rune;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import org.bukkit.ChatColor;

public class SpiritRune implements Rune {
    @Override
    public String getDisplayName() {
        return ChatColor.AQUA + "◆ Spirit Rune";
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
        return "c738b8af8d7ce1a26dc6d40180b3589403e11ef36a66d7c4590037732829542e";
    }
}