package me.adarsh.godspunkycore.features.item.armor.batperson;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class BatpersonBoots implements LeatherArmorStatistics, MaterialFunction {

    @Override
    public double getBaseDefense() {
        return 15;
    }

    @Override
    public String getDisplayName() {
        return "Bat Person Boots";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
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
    public String getLore(){
        return null;
    }

    @Override
    public int getColor() {
        return 0x000000;
    }
}
