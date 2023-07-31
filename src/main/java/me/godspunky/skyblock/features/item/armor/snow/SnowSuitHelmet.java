package me.godspunky.skyblock.features.item.armor.snow;

import me.godspunky.skyblock.features.item.*;

public class SnowSuitHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
    @Override
    public String getDisplayName() {
        return "Snow Suit Helmet";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
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
    public double getBaseHealth() {
        return 180;
    }

    @Override
    public double getBaseDefense() {
        return 100;
    }

    @Override
    public String getURL() {
        return "3d1119643cecfbe004141a1ea4062f8315ca78e503958ac50505e8592c44a601";
    }
}

