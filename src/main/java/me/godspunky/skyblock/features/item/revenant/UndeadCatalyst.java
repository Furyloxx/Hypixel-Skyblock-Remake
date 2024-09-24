package me.godspunky.skyblock.features.item.revenant;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SkullStatistics;

public class UndeadCatalyst implements SkullStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Undead Catalyst";
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
    public String getURL() {
        return "80625369b0a7b052632db6b926a87670219539922836ac5940be26d34bf14e10";
    }
}