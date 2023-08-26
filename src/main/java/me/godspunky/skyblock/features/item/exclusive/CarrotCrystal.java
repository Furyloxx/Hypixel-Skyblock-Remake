package me.godspunky.skyblock.features.item.exclusive;

import me.godspunky.skyblock.features.entity.SEntityType;

public class CarrotCrystal extends FloatingCrystal {
    @Override
    protected SEntityType getCrystalType() {
        return SEntityType.CARROT_CRYSTAL;
    }

    @Override
    public String getURL() {
        return "4d3a6bd98ac1833c664c4909ff8d2dc62ce887bdcf3cc5b3848651ae5af6b";
    }

    @Override
    public String getDisplayName() {
        return "Carrot Crystal";
    }
}
