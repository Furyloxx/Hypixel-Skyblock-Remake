package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

public class UndeadSword implements ToolStatistics, MaterialFunction {

    @Override
    public String getDisplayName() {
        return "Undead Sword";
    }

    @Override
    public int getBaseDamage() {
        return 30;
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }

    @Override
    public String getLore() {
        return ChatColor.GRAY +"Deals "+ChatColor.GREEN+"+100%"+ChatColor.GRAY+" damage to Zombie Pigmen, Skeletons, Withers, and Zombies";
    }
}

