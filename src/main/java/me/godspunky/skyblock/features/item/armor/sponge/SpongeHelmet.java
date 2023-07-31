package me.godspunky.skyblock.features.item.armor.sponge;

import me.godspunky.skyblock.features.item.*;

public class SpongeHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Sponge Helmet";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
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
        return 80;
    }

    @Override
    public String getURL() {
        return "12f096eef87d9f20ccaaba2a02eed6f43e6432a6928fe16467cb4deb5e74118c";
    }
}
