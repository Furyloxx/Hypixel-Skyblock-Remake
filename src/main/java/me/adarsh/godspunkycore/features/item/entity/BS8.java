// 
// Decompiled by Procyon v0.5.36
// 

package me.adarsh.godspunkycore.features.item.entity;


import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SkullStatistics;

public class BS8 implements SkullStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "4f85522ee815d110587fffc74113f419d929598e2463b8ce9d39caa9fb6ff5ab";
    }

    @Override
    public String getDisplayName() {
        return "BZB8";
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
