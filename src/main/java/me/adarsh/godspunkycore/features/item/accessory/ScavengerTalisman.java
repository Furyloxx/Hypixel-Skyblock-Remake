package me.adarsh.godspunkycore.features.item.accessory;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import org.bukkit.ChatColor;

public class ScavengerTalisman implements AccessoryStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "82cde068e99a4f98c31f87b4cc06be14b229aca4f7281a416c7e2f553223db74";
    }

    @Override
    public String getDisplayName() {
        return "Scavenger Talisman";
    }

    @Override
    public String getLore(){
        return ChatColor.GRAY+"Monsters drop coins when killed";
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

