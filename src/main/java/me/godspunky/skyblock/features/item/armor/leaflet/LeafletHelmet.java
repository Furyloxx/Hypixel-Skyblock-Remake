package me.godspunky.skyblock.features.item.armor.leaflet;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class LeafletHelmet implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.HELMET;
    }

    @Override
    public double getBaseHealth() {
        return 20;
    }

    @Override
    public String getDisplayName() {
        return "Leaflet Hat";
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
        SUtil.HelmetRecipe(SMaterial.LEAFLET_HELMET, SMaterial.LEAVES);
    }
}
