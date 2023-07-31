package me.godspunky.skyblock.features.item.armor.silverhunter;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class SilverHunterChestplate  implements ToolStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 185;
    }

    @Override
    public double getBaseHealth() {
        return 185;
    }

    @Override
    public String getDisplayName() {
        return "Silver Hunter Chestplate";
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
        return SpecificItemType.CHESTPLATE;
    }
}

