package me.godspunky.skyblock.features.item.armor.leaflet;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class LeafletBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.BOOTS;
    }

    @Override
    public double getBaseHealth() {
        return 15;
    }

    @Override
    public String getDisplayName() {
        return "Leaflet Boots";
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
        SUtil.BootsRecipe(SMaterial.LEAFLET_BOOTS, SMaterial.LEAVES);
    }
}
