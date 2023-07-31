package me.godspunky.skyblock.features.item.armor.vanilla.chainmail;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class ChainmailBoots implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Chainmail Boots";
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
    public double getBaseDefense() {
        return 7;
    }
}
