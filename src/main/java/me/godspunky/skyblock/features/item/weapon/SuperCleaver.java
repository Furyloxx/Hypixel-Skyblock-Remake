package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

public class SuperCleaver implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public String getAbilityName() {
        return "Cleave";
    }

    @Override
    public String getAbilityDescription() {
        return ChatColor.GRAY +"When hitting an entity, monsters in a "+ChatColor.GREEN+"3"+ChatColor.GRAY+" block range will be hit for a portion of that damage too.";
    }

    @Override
    public int getBaseDamage() {
        return 105;
    }

    @Override
    public double getBaseCritChance() {
        return 0.20;
    }

    @Override
    public double getBaseStrength() {
        return 20;
    }

    @Override
    public String getDisplayName() {
        return "Super Cleaver";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
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
