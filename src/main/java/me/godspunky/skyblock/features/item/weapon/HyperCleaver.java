package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

public class HyperCleaver implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Hyper Cleaver";
    }

    @Override
    public int getBaseDamage() {
        return 175;
    }

    @Override
    public double getBaseStrength() {
        return 50;
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
        return "Cleave";
    }

    @Override
    public String getAbilityDescription() {
        return ChatColor.GRAY+"When hitting an entity, monsters in a"+ChatColor.GRAY+" 4 "+ ChatColor.GRAY +"block range will be hit for a portion of that damage too.";
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
        return null;
    }
}
