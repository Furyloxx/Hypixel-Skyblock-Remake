package me.adarsh.godspunkycore.features.item.armor.snow;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import me.adarsh.godspunkycore.features.item.armor.lapis.LapisArmorBoots;
import me.adarsh.godspunkycore.features.item.armor.lapis.LapisArmorChestplate;
import me.adarsh.godspunkycore.features.item.armor.lapis.LapisArmorHelmet;
import me.adarsh.godspunkycore.features.item.armor.lapis.LapisArmorLeggings;
import org.bukkit.entity.Player;

public class SnowSuitSet implements ArmorSet {
    @Override
    public String getName() {
        return "Cold Thumb";
    }

    @Override
    public String getDescription() {
        return "Allows the wearer to shoot unlimited snowballs when using Frosty the Snow Cannon.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return SnowSuitHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return SnowSuitChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return SnowSuitLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return SnowSuitBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player) {
        return new PlayerBoostStatistics() {
            @Override
            public String getDisplayName() {
                return null;
            }

            @Override
            public Rarity getRarity() {
                return null;
            }

            @Override
            public GenericItemType getType() {
                return null;
            }
        };
    }
}

