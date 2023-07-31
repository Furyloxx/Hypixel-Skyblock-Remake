package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class SpiritSword implements ToolStatistics, MaterialFunction {

    @Override
    public String getDisplayName() {
        return "Spirit Sword";
    }

    @Override
    public int getBaseDamage() {
        return 210;
    }

    @Override
    public double getBaseStrength() {
        return 50;
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
    public List<String> getListLore() {
        return Arrays.asList(ChatColor.GRAY+"Deal"+ChatColor.GREEN+" +2% "+ChatColor.GRAY+"more damage to Undead",
                ChatColor.GREEN+"monster "+ChatColor.GRAY+"for every"+ChatColor.GREEN+" 1% "+ChatColor.GRAY+"of",
                "your missing health.",
                "",
                ChatColor.GOLD+"Spirit Ability: Spirit Bomb",
                "Shoot a Spirit that does",
                ChatColor.RED+"8,000 "+ChatColor.GRAY+"Damage on impact!");
    }
}
