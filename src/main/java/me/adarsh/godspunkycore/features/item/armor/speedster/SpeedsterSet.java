package me.adarsh.godspunkycore.features.item.armor.speedster;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class SpeedsterSet implements ArmorSet {
    @Override
    public String getName() {
        return "Bonus Speed";
    }

    @Override
    public String getDescription() {
        return "Increases ✦ Speed by +20.";
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

