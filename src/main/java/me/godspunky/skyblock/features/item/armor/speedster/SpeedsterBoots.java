package me.godspunky.skyblock.features.item.armor.speedster;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class SpeedsterBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.BOOTS;
    }

    @Override
    public double getBaseSpeed() {
        return 0.15;
    }

    @Override
    public double getBaseDefense() {
        return 65;
    }

    @Override
    public String getDisplayName() {
        return "Speedster Boots";
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
    public int getColor() {
        return 0xE0FCF7;
    }

    @Override
    public void load() {
        SUtil.BootsRecipe(SMaterial.SPEEDSTER_BOOTS,SMaterial.ENCHANTED_SUGARCANE);
    }
}
