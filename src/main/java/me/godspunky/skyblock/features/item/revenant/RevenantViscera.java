package me.godspunky.skyblock.features.item.revenant;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.Rarity;

public class RevenantViscera implements MaterialStatistics, MaterialFunction{
    @Override
    public String getDisplayName() {
        return "Revenant Viscera";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.SLAYER_ITEM;
    }

    @Override
    public boolean isEnchanted() {
        return true;
    }
}
