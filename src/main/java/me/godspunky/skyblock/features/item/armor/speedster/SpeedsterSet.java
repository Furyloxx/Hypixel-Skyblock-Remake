package me.godspunky.skyblock.features.item.armor.speedster;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SpeedsterSet implements ArmorSet {
    @Override
    public String getName() {
        return "Bonus Speed";
    }

    @Override
    public String getDescription() {
        return "Increases "+ ChatColor.WHITE +"✦ Speed"+ChatColor.GRAY+" by"+ChatColor.GREEN+" +20.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return SpeedsterHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return SpeedsterChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return SpeedsterLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return SpeedsterBoots.class;
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

            @Override
            public double getBaseSpeed() {
                return 0.50;
            }
        };
    }
}

