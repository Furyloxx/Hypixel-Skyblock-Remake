// 
// Decompiled by Procyon v0.5.36
// 

package me.godspunky.skyblock.features.item.entity;


import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SkullStatistics;

public class BS7 implements SkullStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "7a2df315b43583b1896231b77bae1a507dbd7e43ad86c1cfbe3b2b8ef3430e9e";
    }

    @Override
    public String getDisplayName() {
        return "BZB7";
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
