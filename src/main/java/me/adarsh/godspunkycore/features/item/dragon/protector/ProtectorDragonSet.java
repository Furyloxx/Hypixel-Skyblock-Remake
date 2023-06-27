package me.adarsh.godspunkycore.features.item.dragon.protector;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class ProtectorDragonSet implements ArmorSet {
    @Override
    public String getName() {
        return "Protective Blood";
    }

    @Override
    public String getDescription() {
        return "Increases the Defense bonus of each armor piece by 1% for each percent of missing Health.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return ProtectorDragonHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return ProtectorDragonChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return ProtectorDragonLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return ProtectorDragonBoots.class;
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
            public double getBaseDefense() {
                double percentHealth = player.getMaxHealth() * 0.01;
                int additive = (int) ((player.getMaxHealth() - player.getHealth()) * percentHealth);
                return additive * 4;
            }
        };
    }
}