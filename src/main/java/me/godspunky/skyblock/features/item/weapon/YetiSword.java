package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

public class YetiSword implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Yeti Sword";
    }

    @Override
    public int getBaseDamage() {
        return 150;
    }

    @Override
    public double getBaseStrength() {
        return 170;
    }

    @Override
    public double getBaseIntelligence() {
        return 50;
    }

    @Override
    public int getManaCost() {
        return 250;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 20;
    }

    @Override
    public String getAbilityName() {
        return "Terrain Toss";
    }

    @Override
    public String getAbilityDescription() {
        return ChatColor.GRAY+"Throws a chunk of terrain in the direction you are facing! Deals up to "+ ChatColor.RED +"15000"+ChatColor.GRAY+" damage.";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
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

