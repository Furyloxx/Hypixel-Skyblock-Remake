package me.adarsh.godspunkycore.item.armor.miner;

import me.adarsh.godspunkycore.item.*;

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