package me.adarsh.godspunkycore.item.armor.vanilla.chainmail;

import me.adarsh.godspunkycore.item.*;

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
