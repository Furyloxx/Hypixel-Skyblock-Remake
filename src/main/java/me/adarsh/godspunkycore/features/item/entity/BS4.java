// 
// Decompiled by Procyon v0.5.36
// 

package me.adarsh.godspunkycore.features.item.entity;


import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SkullStatistics;

public class BS4 implements SkullStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "76387fc246893d92a6dd9ea1b52dcd581e991eeee2e263b27fff1bcf1b154eb7";
    }

    @Override
    public String getDisplayName() {
        return "BZB4";
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
