package me.adarsh.godspunkycore.features.item.armor;

import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import org.bukkit.entity.Player;

public interface ArmorSet {
    String getName();

    String getDescription();

    Class<? extends MaterialStatistics> getHelmet();

    Class<? extends MaterialStatistics> getChestplate();

    Class<? extends MaterialStatistics> getLeggings();

    Class<? extends MaterialStatistics> getBoots();

    default PlayerBoostStatistics whileHasFullSet(Player player) {
        return null;
    }
}