package me.adarsh.godspunkycore.features.item.accessory;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import org.bukkit.ChatColor;

public class IntimidationTalisman implements AccessoryStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "f931ca9e46fcf351354fa022992fa07cc59be50ffb80e9dd8af4973378cf89d5";
    }

    @Override
    public String getDisplayName() {
        return "Intimidation Talisman";
    }

    @Override
    public String getLore(){
        return ChatColor.GRAY+"Level"+ChatColor.GREEN+" 1 "+ChatColor.GRAY+ "monsters will no"+
                ChatColor.GRAY+"longer target you.";
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
