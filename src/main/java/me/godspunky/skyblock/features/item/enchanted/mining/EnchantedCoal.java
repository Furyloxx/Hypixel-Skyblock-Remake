package me.godspunky.skyblock.features.item.enchanted.mining;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.enchanted.EnchantedMaterialStatistics;
import org.bukkit.ChatColor;

public class EnchantedCoal implements EnchantedMaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Enchanted Coal";
    }

    @Override
    public String getLore(){
        return ChatColor.GRAY+"Increases the speed of your minion by "+ChatColor.GREEN+"10% "+ChatColor.GRAY+"for 24 hours.";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public boolean isEnchanted() {
        return true;
    }

    @Override
    public SMaterial getCraftingMaterial() {
        return SMaterial.COAL;
    }

    @Override
    public MaterialQuantifiable getResult() {
        return new MaterialQuantifiable(SMaterial.ENCHANTED_COAL);
    }

    @Override
    public SMaterial getBlockCraftingMaterial() {
        return SMaterial.COAL_BLOCK;
    }
}