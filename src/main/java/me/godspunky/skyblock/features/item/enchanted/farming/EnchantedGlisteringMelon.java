package me.godspunky.skyblock.features.item.enchanted.farming;

import me.godspunky.skyblock.features.item.*;

public class EnchantedGlisteringMelon implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Enchanted Glistering Melon";
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
