package me.godspunky.skyblock.features.item.armor.miner;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class MinerHelmet implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Miner Helmet";
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

    @Override
    public double getBaseDefense() {
        return 5;
    }
}