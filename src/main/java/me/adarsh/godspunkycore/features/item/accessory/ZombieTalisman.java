package me.adarsh.godspunkycore.features.item.accessory;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import org.bukkit.ChatColor;

public class ZombieTalisman implements AccessoryStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "64528b3229660f3dfab42414f59ee8fd01e80081dd3df30869536ba9b414e089";
    }

    @Override
    public String getDisplayName() {
        return "Zombie Talisman";
    }

    @Override
    public String getLore(){
        return ChatColor.GRAY+"Reduces the damage taken from"+
                ChatColor.GRAY+"Zombies by "+ChatColor.GREEN+"5%";
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
