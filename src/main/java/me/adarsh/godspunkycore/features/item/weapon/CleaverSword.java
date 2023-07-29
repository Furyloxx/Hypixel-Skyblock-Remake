package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;
import org.bukkit.ChatColor;

public class CleaverSword implements ToolStatistics, MaterialFunction {

    @Override
    public int getBaseDamage() {
        return 40;
    }

    @Override
    public double getBaseStrength() {
        return 10;
    }

    @Override
    public String getDisplayName() {
        return "Cleaver Sword";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
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
        return ChatColor.GRAY+"When hitting a mob, any entity within a "+ChatColor.GREEN+"3 " +"block radius will take a small portion of damage.";
    }
}

