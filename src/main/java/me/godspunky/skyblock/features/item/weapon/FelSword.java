package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

public class FelSword implements ToolStatistics, MaterialFunction {

    @Override
    public String getDisplayName() {
        return "Fel Sword";
    }

    @Override
    public int getBaseDamage() {
        return 190;
    }

    @Override
    public double getBaseStrength() {
        return 135;
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
        return ChatColor.GRAY+"Every"+ChatColor.GREEN+" 100 "+ChatColor.GRAY+"Kills with this sword grants "+ChatColor.RED+"1 "+ChatColor.GRAY+"Damage, up to"+ChatColor.RED+" 100 "+ChatColor.GRAY+"extra.";
    }
}
