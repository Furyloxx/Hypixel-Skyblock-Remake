package me.godspunky.skyblock.features.item.armor.golem;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class GolemArmorBoots implements ToolStatistics, MaterialFunction {
    @Override
    public double getBaseDefense() {
        return 40;
    }

    @Override
    public double getBaseHealth() {
        return 40;
    }

    @Override
    public String getDisplayName() {
        return "Golem Armor Boots";
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
