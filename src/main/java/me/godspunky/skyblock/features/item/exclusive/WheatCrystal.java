package me.godspunky.skyblock.features.item.exclusive;

import me.godspunky.skyblock.features.entity.SEntityType;

public class WheatCrystal extends FloatingCrystal {
    @Override
    protected SEntityType getCrystalType() {
        return SEntityType.WHEAT_CRYSTAL;
    }

    @Override
    public String getURL() {
        return "d7d30431c2945ced873c27575eeaac22adb28adac7fbd89b56eb9e93979ce0fd";
    }

    @Override
    public String getDisplayName() {
        return "Wheat Crystal";
    }
}