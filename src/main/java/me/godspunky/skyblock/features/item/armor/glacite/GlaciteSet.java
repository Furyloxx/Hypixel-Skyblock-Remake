package me.godspunky.skyblock.features.item.armor.glacite;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class GlaciteSet implements ArmorSet {
    @Override
    public String getName() {
        return "Expert Miner";
    }

    @Override
    public String getDescription() {
        return "Grants +2⸕ Mining Speed for each of your mining levels. The Defense of this item is doubled while on a mining island";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return GlaciteHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return GlaciteChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return GlaciteLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return GlaciteBoots.class;
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
