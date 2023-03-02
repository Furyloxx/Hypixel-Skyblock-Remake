package me.adarsh.godspunkycore.item.dragon.old;

import me.adarsh.godspunkycore.item.MaterialStatistics;
import me.adarsh.godspunkycore.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class OldDragonSet implements ArmorSet {
    @Override
    public String getName() {
        return "Old Blood";
    }

    @Override
    public String getDescription() {
        return "Increases the strength of Growth, Protection, Feather Falling, Sugar Rush, and True Protection enchantments while worn.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return OldDragonHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return OldDragonChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return OldDragonLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return OldDragonBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player) {
        return null; // TODO
    }
}