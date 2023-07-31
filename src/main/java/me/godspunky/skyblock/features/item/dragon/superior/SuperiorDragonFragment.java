package me.godspunky.skyblock.features.item.dragon.superior;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SkullStatistics;

public class SuperiorDragonFragment implements SkullStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "6f89b150be9c4c5249f355f68ea0c4391300a9be1f260d750fc35a1817ad796e";
    }

    @Override
    public String getDisplayName() {
        return "Superior Dragon Fragment";
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