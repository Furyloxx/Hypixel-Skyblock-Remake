package me.godspunky.skyblock.features.item.armor.mastiff;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class MastiffSet implements ArmorSet {
    @Override
    public String getName() {
        return "Absolute Unit";
    }

    @Override
    public String getDescription() {
        return "+50 ❤ HP per 1% ☠ Crit Damage. Regain 2% of max ❤ HP when hit (1s cooldown). Receive -20% damage from wolves. Your crit damage is 50% less effective.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return MastiffHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return MastiffChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return MastiffLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return MastiffBoots.class;
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