package me.godspunky.skyblock.features.item.exclusive;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.*;

public class TestItem implements SkullStatistics, MaterialFunction, Enchantable {
    @Override
    public String getURL() {
        return "c0340923a6de4825a176813d133503eff186db0896e32b6704928c2a2bf68422";
    }

    @Override
    public String getDisplayName() {
        return "Test Item";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EXCLUSIVE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }
}