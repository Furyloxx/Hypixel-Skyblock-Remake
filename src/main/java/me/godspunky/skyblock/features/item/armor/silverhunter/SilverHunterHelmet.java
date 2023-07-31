package me.godspunky.skyblock.features.item.armor.silverhunter;

import me.godspunky.skyblock.features.item.*;

public class SilverHunterHelmet  implements ToolStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 130;
    }

    @Override
    public double getBaseHealth() {
        return 130;
    }

    @Override
    public String getDisplayName() {
        return "Silver Hunter Helmet";
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
        return SpecificItemType.HELMET;
    }
}

