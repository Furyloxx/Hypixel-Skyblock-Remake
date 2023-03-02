package me.adarsh.godspunkycore.item.armor;

import me.adarsh.godspunkycore.item.MaterialStatistics;
import me.adarsh.godspunkycore.item.PlayerBoostStatistics;
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