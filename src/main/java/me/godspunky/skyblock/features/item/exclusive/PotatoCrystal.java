package me.godspunky.skyblock.features.item.exclusive;

import me.godspunky.skyblock.features.entity.SEntityType;

public class PotatoCrystal extends FloatingCrystal {
    @Override
    protected SEntityType getCrystalType() {
        return SEntityType.POTATO_CRYSTAL;
    }

    @Override
    public String getURL() {
        return "9265f96f54b78885c46e7d2f86b1c1dbfe643c6060fc7fcc9834c3e3fd595135";
    }

    @Override
    public String getDisplayName() {
        return "Potato Crystal";
    }
}
