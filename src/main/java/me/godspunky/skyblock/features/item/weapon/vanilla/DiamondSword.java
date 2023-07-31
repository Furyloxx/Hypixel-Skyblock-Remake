package me.godspunky.skyblock.features.item.weapon.vanilla;

import me.godspunky.skyblock.features.item.*;

public class DiamondSword implements ToolStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Diamond Sword";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public int getBaseDamage() {
        return 35;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }
}