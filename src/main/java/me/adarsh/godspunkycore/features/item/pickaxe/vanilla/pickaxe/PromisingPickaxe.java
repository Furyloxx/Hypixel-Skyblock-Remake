package me.adarsh.godspunkycore.features.item.pickaxe.vanilla.pickaxe;

import me.adarsh.godspunkycore.features.item.*;
import org.bukkit.ChatColor;

public class PromisingPickaxe implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Promising Pickaxe";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public int getBaseDamage() {
        return 20;
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
        return SpecificItemType.PICKAXE;
    }
}
