package me.godspunky.skyblock.features.item.armor.mushroom;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class MushroomBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseHealth() {
        return 15;
    }

    @Override
    public String getDisplayName() {
        return "Mushroom Boots";
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
    public SpecificItemType getSpecificType() {
        return SpecificItemType.BOOTS;
    }

    @Override
    public int getColor() {
        return 0xFF0000;
    }

    @Override
    public void load(){
        SUtil.BootsRecipe(SMaterial.MUSHROOM_BOOTS, SMaterial.RED_MUSHROOM);
    }
}
