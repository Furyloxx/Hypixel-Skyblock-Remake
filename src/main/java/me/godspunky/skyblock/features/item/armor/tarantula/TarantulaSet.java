package me.godspunky.skyblock.features.item.armor.tarantula;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class TarantulaSet implements ArmorSet {
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
        return TarantulaHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return TarantulaChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return TarantulaLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return TarantulaBoots.class;
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
