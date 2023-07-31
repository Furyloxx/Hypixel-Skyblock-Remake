package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import net.md_5.bungee.api.ChatColor;

public class VoidwalkerKatana implements ToolStatistics, MaterialFunction {
    public int getBaseDamage() {
        return 80;
    }

    public double getBaseStrength() {
        return 40.0D;
    }

    public double getBaseCritDamage() {
        return 0.1D;
    }

    public String getDisplayName() {
        return "Voidwalker Katana";
    }

    public String getLore() {
        return "Deal " + ChatColor.GREEN + "+100% " + ChatColor.GRAY + "damage to Endermen.";
    }

    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }
}
