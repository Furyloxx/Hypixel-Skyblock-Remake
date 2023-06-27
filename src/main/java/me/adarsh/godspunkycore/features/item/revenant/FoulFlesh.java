package me.adarsh.godspunkycore.features.item.revenant;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;

public class FoulFlesh implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Foul Flesh";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }
}