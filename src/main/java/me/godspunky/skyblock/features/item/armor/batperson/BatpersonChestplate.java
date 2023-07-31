package me.godspunky.skyblock.features.item.armor.batperson;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;

public class BatpersonChestplate implements LeatherArmorStatistics, MaterialFunction {

    @Override
    public double getBaseDefense() {
        return 35;
    }

    @Override
    public String getDisplayName() {
        return "Bat Person Chestplate";
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
        return SpecificItemType.CHESTPLATE;
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

