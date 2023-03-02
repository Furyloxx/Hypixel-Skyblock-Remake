package me.adarsh.godspunkycore.item.dragon.unstable;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SkullStatistics;

public class UnstableDragonFragment implements SkullStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "98228c234c3903c512a5a0aa45260e7b567e0e20eefc7d561ccec97b295871af";
    }

    @Override
    public String getDisplayName() {
        return "Unstable Dragon Fragment";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }
}