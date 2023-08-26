package me.godspunky.skyblock.features.item.exclusive;

import me.godspunky.skyblock.features.entity.SEntityType;

public class PotatoCrystal extends FloatingCrystal {
    @Override
    protected SEntityType getCrystalType() {
        return SEntityType.POTATO_CRYSTAL;
    }

    @Override
    public String getURL() {
        return "16ec293db5fa85e27b675fbdba88f871edef395734b5d9e327eada6be3814340";
    }

    @Override
    public String getDisplayName() {
        return "Potato Crystal";
    }
}
