package me.godspunky.skyblock.features.item.axe.vanilla.axe;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

public class PromisingAxe implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Promising Axe";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public int getBaseDamage() {
        return 25;
    }

    @Override
    public String getLore(){
        return ChatColor.GRAY+"Gains a higher level of " +
                ChatColor.GRAY+"Enchantment when breaking "+
                ChatColor.GRAY+"blocks.";
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.TOOL;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.AXE;
    }
}
