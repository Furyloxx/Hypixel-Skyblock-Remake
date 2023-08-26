package me.godspunky.skyblock.features.item.armor.leaflet;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class LeafletChestplate implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public double getBaseHealth() {
        return 35;
    }

    @Override
    public String getDisplayName() {
        return "Leaflet Chestplate";
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
        SUtil.ChestplateRecipe(SMaterial.LEAFLET_CHESTPLATE, SMaterial.LEAVES);
    }
}
