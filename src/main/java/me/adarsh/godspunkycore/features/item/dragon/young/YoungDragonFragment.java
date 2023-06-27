package me.adarsh.godspunkycore.features.item.dragon.young;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SkullStatistics;

public class YoungDragonFragment implements SkullStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "4b5bd6b64e8bd6c58f5cd1e79a5502d4448bafc006d2fe0568f6a0d6b86d449e";
    }

    @Override
    public String getDisplayName() {
        return "Young Dragon Fragment";
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