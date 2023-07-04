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
        return "Octodexterity";
    }

    @Override
    public String getDescription() {
        return "Every 4th strike, deal double damage and apply Venom reducing healing by 40% for 4 seconds.";
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