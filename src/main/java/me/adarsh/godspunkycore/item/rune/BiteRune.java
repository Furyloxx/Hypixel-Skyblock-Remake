package me.adarsh.godspunkycore.item.rune;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.Rune;
import me.adarsh.godspunkycore.item.SpecificItemType;
import org.bukkit.ChatColor;

public class BiteRune implements Rune
{
    @Override
    public String getDisplayName()
    {
        return ChatColor.GREEN + "◆ Bite Rune";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ITEM;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.COSMETIC;
    }

    @Override
    public String getURL()
    {
        return "43a1ad4fcc42fb63c681328e42d63c83ca193b333af2a426728a25a8cc600692";
    }
}