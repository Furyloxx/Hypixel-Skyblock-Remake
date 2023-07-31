package me.godspunky.skyblock.features.item.armor.shadowassassin;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class ShadowAssassinHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
    @Override
    public String getURL() {
        return "9598fcbbf65b9ff66da99487403e4baf7e4c50144d06c7417bbded578d76d004";
    }

    @Override
    public String getDisplayName() {
        return "Shadow Assassin Helmet";
    }

    @Override
    public double getBaseStrength() {
        return 25;
    }

    @Override
    public double getBaseCritDamage() {
        return 0.25;
    }

    @Override
    public double getBaseHealth() {
        return 160;
    }

    @Override
    public double getBaseDefense() {
        return 70;
    }

    @Override
    public double getBaseSpeed() {
        return 0.07;
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
    public String getLore() {
        return null;
    }
}
