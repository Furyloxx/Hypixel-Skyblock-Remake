package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

public class AspectOfTheVoid implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Aspect Of The Void";
    }

    @Override
    public int getBaseDamage() {
        return 120;
    }

    @Override
    public double getBaseStrength() {
        return 100;
    }

    @Override
    public int getManaCost() {
        return 45;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public String getAbilityName() {
        return "Instant Transmission";
    }

    @Override
    public String getAbilityDescription() {
        return ChatColor.GRAY +"Teleports you "+ChatColor.GREEN+"8 blocks "+ChatColor.GRAY+"ahead and gain "+ChatColor.GREEN+"50% "+ChatColor.WHITE+"Speed"+ChatColor.GRAY+" for 3 seconds.";
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
