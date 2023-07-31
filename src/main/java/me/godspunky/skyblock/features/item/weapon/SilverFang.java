package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;

public class SilverFang implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Silver Fang";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }

    @Override
    public int getBaseDamage() {
        return 100;
    }
}
