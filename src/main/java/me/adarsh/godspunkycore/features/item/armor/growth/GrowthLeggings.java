package me.adarsh.godspunkycore.features.item.armor.growth;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.SpecificItemType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;

public class GrowthLeggings  implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 40;
    }

    @Override
    public double getBaseHealth(){return 80;}

    @Override
    public String getDisplayName() {
        return "Leggings of Growth";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public int getColor() {
        return 0x00BE00;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.LEGGINGS;
    }
}

