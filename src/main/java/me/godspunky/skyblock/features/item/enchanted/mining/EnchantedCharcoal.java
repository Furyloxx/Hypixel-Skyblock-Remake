package me.godspunky.skyblock.features.item.enchanted.mining;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.Rarity;

public class EnchantedCharcoal implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Enchanted Charcoal";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
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