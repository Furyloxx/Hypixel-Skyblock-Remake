package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

public class EndSword implements ToolStatistics, MaterialFunction {

    @Override
    public String getDisplayName() {
        return "End Sword";
    }

    @Override
    public int getBaseDamage() {
        return 35;
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
        return ChatColor.GRAY +"Deals"+ChatColor.GREEN+" +100% "+ChatColor.GRAY+"damage to Endermites, Endermen, and Ender Dragons.";
    }
}
