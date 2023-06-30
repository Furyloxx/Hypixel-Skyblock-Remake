package me.adarsh.godspunkycore.features.item.armor.glacite;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class GlaciteLeggings implements LeatherArmorStatistics, MaterialFunction {

    @Override
    public double getBaseDefense() {
        return 125;
    }

    @Override
    public double getBaseSpeed(){return 0.15;}

    @Override
    public String getDisplayName() {
        return "Glacite Leggings";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public int getColor() {
        return 0x03FCF8;
    }
}
