package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;
import org.bukkit.ChatColor;

public class FlamingSword implements ToolStatistics, MaterialFunction {

    @Override
    public String getDisplayName() {
        return "Flaming Sword";
    }

    @Override
    public int getBaseDamage() {
        return 50;
    }

    @Override
    public double getBaseStrength(){return 20;}

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
        return ChatColor.GRAY+"Ignites enemies for "+ChatColor.GREEN+"3s.";
    }
}

