package me.adarsh.godspunkycore.features.item.accessory;

import me.adarsh.godspunkycore.features.item.*;

public interface AccessoryStatistics extends PlayerBoostStatistics, SkullStatistics, Reforgable {
    @Override
    default GenericItemType getType() {
        return GenericItemType.ACCESSORY;
    }

    @Override
    default SpecificItemType getSpecificType() {
        return SpecificItemType.ACCESSORY;
    }
}