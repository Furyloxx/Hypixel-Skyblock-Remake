package me.godspunky.skyblock.features.item.armor.magma;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class MagmaSet implements ArmorSet {
    @Override
    public String getName() {
        return "Absorb";
    }

    @Override
    public String getDescription() {
        return "Every 10 Magma Cubes killed gives the wearer +1 ❤ Health and +1 ✎ Intelligence while wearing the set. Max 200 each.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return MagmaHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return MagmaChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return MagmaLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return MagmaBoots.class;
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


