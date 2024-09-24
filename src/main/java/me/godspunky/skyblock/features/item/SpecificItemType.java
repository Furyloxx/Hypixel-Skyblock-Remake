package me.godspunky.skyblock.features.item;

import lombok.Getter;

public enum SpecificItemType {
    SWORD(false),
    HELMET(false),
    CHESTPLATE(false),
    LEGGINGS(false),
    BOOTS(false),
    BOW(false),
    COSMETIC(false),
    ACCESSORY(false),
    AXE(false),
    PICKAXE(false),
    SHOVEL(false),
    HOE(false),
    SHEARS(false),
    DUNGEON_ITEM,

    LONGSWORD(false),

    WAND(false),
    NONE,
    ROD(false),
    ARROW_POISON,
    FORGESBLE_ITEM(false),
    EQUIPMENT(false),
    REFORGE_STONE(false),
    ADMIN_ITEMS(false)
    ;

    @Getter
    private final boolean stackable;

    SpecificItemType(boolean stackable) {
        this.stackable = stackable;
    }

    SpecificItemType() {
        this(true);
    }

    public String getName() {
        return name().replaceAll("_", " ");
    }
}