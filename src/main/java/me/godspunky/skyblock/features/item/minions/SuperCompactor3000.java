package me.godspunky.skyblock.features.item.minions;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.enchanted.EnchantedMaterialStatistics;
import org.bukkit.ChatColor;

public class SuperCompactor3000 implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Super Compactor 3000";
    }

    @Override
    public String getLore() {
        return ChatColor.GRAY+"This item can be used as a minion upgrade. This will automatically turn materials that a minion produces into their enchanted form.";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public boolean isEnchanted() {
        return true;
    }

}
