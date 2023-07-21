// 
// Decompiled by Procyon v0.5.36
// 

package me.adarsh.godspunkycore.features.item.entity;


import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SkullStatistics;

public class BS2 implements SkullStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "eef162def845aa3dc7d46cd08a7bf95bbdfd32d381215aa41bffad5224298728";
    }

    @Override
    public String getDisplayName() {
        return "BZB2";
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
