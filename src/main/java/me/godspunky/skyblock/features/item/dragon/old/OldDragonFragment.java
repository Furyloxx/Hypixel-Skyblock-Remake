package me.godspunky.skyblock.features.item.dragon.old;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.SkullStatistics;

public class OldDragonFragment implements SkullStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "7aa09ad177fbccc53fa316cc04bdd2c9366baed889df76c5a29defea8170def5";
    }

    @Override
    public String getDisplayName() {
        return "Old Dragon Fragment";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }
}