package me.adarsh.godspunkycore.features.item.armor.spooky;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class SpookySet implements ArmorSet {
    @Override
    public String getName() {
        return "Candy Man";
    }

    @Override
    public String getDescription() {
        return "Grants an additional +5% chance to find rare Candy.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return SpookyHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return SpookyChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return SpookyLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return SpookyBoots.class;
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