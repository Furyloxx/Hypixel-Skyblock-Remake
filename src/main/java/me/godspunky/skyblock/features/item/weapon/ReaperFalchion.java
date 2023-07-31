package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

public class ReaperFalchion implements ToolStatistics, MaterialFunction {
    public int getBaseDamage() {
        return 120;
    }

    public double getBaseStrength() {
        return 100.0D;
    }

    public double getBaseIntelligence() {
        return 200.0D;
    }

    public String getDisplayName() {
        return "Reaper Falchion";
    }

    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    public String getLore() {
        return "Heal " + ChatColor.RED + "10" + ChatColor.RED + "❤" + ChatColor.GRAY + " per hit. Deal " + ChatColor.GREEN + "+200% " + ChatColor.GRAY + "damage to Zombies. Receive " + ChatColor.GREEN + "20% " + ChatColor.GRAY + "less damage from Zombies when held.";
    }

    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }
}