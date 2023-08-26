package me.godspunky.skyblock.features.item.armor.leaflet;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class LeafletLeggings implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public double getBaseHealth() {
        return 30;
    }

    @Override
    public String getDisplayName() {
        return "Leaflet Leggings";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public int getColor() {
        return 0x4DCC4D;
    }

    @Override
    public void load(){
        SUtil.LeggingsRecipe(SMaterial.LEAFLET_LEGGINGS, SMaterial.LEAVES);
    }
}
