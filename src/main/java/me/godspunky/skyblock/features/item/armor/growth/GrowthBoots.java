package me.godspunky.skyblock.features.item.armor.growth;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.armor.LeatherArmorStatistics;
import me.godspunky.skyblock.util.SUtil;

public class GrowthBoots implements LeatherArmorStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 25;
    }

    @Override
    public double getBaseHealth(){return 50;}

    @Override
    public String getDisplayName() {
        return "Boots of Growth";
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
        return SpecificItemType.BOOTS;
    }

    @Override
    public void load() {
        SUtil.BootsRecipe(SMaterial.GROWTH_BOOTS,SMaterial.ENCHANTED_DARK_OAK_WOOD,64);
    }
}
