package me.adarsh.godspunkycore.features.item.armor.sharkscale;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class SharkScaleSet implements ArmorSet {
    @Override
    public String getName() {
        return "Absorb";
    }

    @Override
    public String getDescription() {
        return "Doubles your ❈ Defense while in water.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return SharkScaleHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return SharkScaleChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return SharkScaleleggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return SharkScaleBoots.class;
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
