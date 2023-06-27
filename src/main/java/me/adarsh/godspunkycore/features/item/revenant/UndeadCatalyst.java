package me.adarsh.godspunkycore.features.item.revenant;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SkullStatistics;

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
        return GenericItemType.ITEM;
    }

    @Override
    public String getURL() {
        return "80625369b0a7b052632db6b926a87670219539922836ac5940be26d34bf14e10";
    }
}