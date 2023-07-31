package me.godspunky.skyblock.features.item.accessory;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import org.bukkit.ChatColor;

public class SkeletonTalisman implements AccessoryStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "c4070b639225b2d4f2a9f794f5acc48cb696eec49d72ebd54817f8bb52d59f34";
    }

    @Override
    public String getDisplayName() {
        return "Skeleton Talisman";
    }

    @Override
    public String getLore(){
        return ChatColor.GRAY+"Reduces the damage taken from"+
                ChatColor.GRAY+"Skeleton by "+ChatColor.GREEN+"5%";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ACCESSORY;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.ACCESSORY;
    }
}
