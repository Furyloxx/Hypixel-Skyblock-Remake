package me.adarsh.godspunkycore.features.item.armor.glacite;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class GlaciteBoots implements LeatherArmorStatistics, MaterialFunction {

    @Override
    public double getBaseDefense() {
        return 70;
    }

    @Override
    public double getBaseSpeed(){return 0.10;}

    @Override
    public String getDisplayName() {
        return "Glacite Boots";
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
        return SpecificItemType.BOOTS;
    }

    @Override
    public int getColor() {
        return 0x03FCF8;
    }
}