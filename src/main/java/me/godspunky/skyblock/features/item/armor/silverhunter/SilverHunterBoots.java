package me.godspunky.skyblock.features.item.armor.silverhunter;

import me.godspunky.skyblock.features.item.*;

public class SilverHunterBoots implements ToolStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 110;
    }

    @Override
    public double getBaseHealth() {
        return 110;
    }

    @Override
    public String getDisplayName() {
        return "Silver Hunter Boots";
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
    public SpecificItemType getSpecificType() {
        return SpecificItemType.BOOTS;
    }
}
