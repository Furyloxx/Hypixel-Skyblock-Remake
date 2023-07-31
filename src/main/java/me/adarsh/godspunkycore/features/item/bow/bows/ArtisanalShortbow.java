package me.adarsh.godspunkycore.features.item.bow.bows;

import me.adarsh.godspunkycore.features.item.*;
import org.bukkit.ChatColor;

public class ArtisanalShortbow implements ToolStatistics, MaterialFunction{

    @Override
    public String getDisplayName() {
        return "Artisanal Shortbow";
    }

    @Override
    public int getBaseDamage() {
        return 40;
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.RANGED_WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.BOW;
    }

    @Override
    public String getLore() {
        return ChatColor.GOLD+"Shortbow: Instantly shoots!";
    }
}

