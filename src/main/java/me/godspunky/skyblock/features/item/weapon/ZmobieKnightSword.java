package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

public class ZmobieKnightSword implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Zombie Knight Sword";
    }

    @Override
    public int getBaseDamage() {
        return 82;
    }

    @Override
    public double getBaseStrength() {
        return 21;
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public String getAbilityName() {
        return "Zombie Knight";
    }

    @Override
    public String getAbilityDescription() {
        return ChatColor.GRAY +"Gains"+ChatColor.RED+" +30❁"+ChatColor.GRAY+" Strength when used with Zombie Knight Armor";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
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
        return ChatColor.GREEN+"Perfect 52500/52500";
    }
}