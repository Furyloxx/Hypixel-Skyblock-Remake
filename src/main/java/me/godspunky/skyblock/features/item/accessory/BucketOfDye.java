package me.godspunky.skyblock.features.item.accessory;

import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class BucketOfDye implements AccessoryStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "75823385b0c2e0bf9c3c71599daf56824a76a6f240b6f4c4ad927879d97083d8";
    }

    @Override
    public String getDisplayName() {
        return "Bucket Of Dye";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ACCESSORY;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.ACCESSORY;
    }

    @Override
    public List<String> getListLore() {
        return Arrays.asList("§7§7Increases your chance of dropping",
    "§7Dyes by §a1%§7.");
    }
}