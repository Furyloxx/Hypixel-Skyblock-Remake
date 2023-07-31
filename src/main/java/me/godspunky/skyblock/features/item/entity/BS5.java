// 
// Decompiled by Procyon v0.5.36
// 

package me.godspunky.skyblock.features.item.entity;


import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SkullStatistics;

public class BS5 implements SkullStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "f868e6a5c4a445d60a3050b5bec1d37af1b25943745d2d479800c8436488065a";
    }

    @Override
    public String getDisplayName() {
        return "BZB5";
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
