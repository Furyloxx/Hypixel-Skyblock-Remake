package me.godspunky.skyblock.features.item.armor.silverhunter;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class SilverHunterLeggings  implements ToolStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 160;
    }

    @Override
    public double getBaseHealth() {
        return 160;
    }

    @Override
    public String getDisplayName() {
        return "Silver Hunter Leggings";
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
        return SpecificItemType.LEGGINGS;
    }
}

