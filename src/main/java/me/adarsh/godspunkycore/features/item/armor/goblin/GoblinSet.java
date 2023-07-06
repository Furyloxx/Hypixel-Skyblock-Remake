package me.adarsh.godspunkycore.features.item.armor.goblin;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import me.adarsh.godspunkycore.features.item.armor.leaflet.LeafletBoots;
import me.adarsh.godspunkycore.features.item.armor.leaflet.LeafletChestplate;
import me.adarsh.godspunkycore.features.item.armor.leaflet.LeafletHelmet;
import me.adarsh.godspunkycore.features.item.armor.leaflet.LeafletLeggings;
import org.bukkit.entity.Player;

public class GoblinSet implements ArmorSet {
    @Override
    public String getName() {
        return "Smart Miner";
    }

    @Override
    public String getDescription() {
        return "Converts your Intelligence into Mining Speed. +1 Mining Speed for every 15 Intelligence removed.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return LeafletHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return LeafletChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return LeafletLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return LeafletBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player) {
        return new PlayerBoostStatistics() {
            @Override
            public String getDisplayName() {
                return null;
            }

            @Override
            public double getBaseIntelligence(){return -15;}

            @Override
            public Rarity getRarity() {
                return Rarity.UNCOMMON;
            }

            @Override
            public String getLore() {
                return null;
            }

            @Override
            public GenericItemType getType() {
                return GenericItemType.ARMOR;
            }
        };
    }
}
