// 
// Decompiled by Procyon v0.5.36
// 

package me.godspunky.skyblock.features.item.entity;


import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SkullStatistics;

public class BS9 implements SkullStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "a26ec7cd3b6ae249997137c1b94867c66e97499da071bf50adfd37034132fa03";
    }

    @Override
    public String getDisplayName() {
        return "BZB9";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EXCLUSIVE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }
}
