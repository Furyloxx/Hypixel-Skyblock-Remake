package me.godspunky.skyblock.features.item.enchanted;

import me.godspunky.skyblock.features.item.*;

public class EnchantedCarrotOnStick implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Enchanted Carrot on a Stick";
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
