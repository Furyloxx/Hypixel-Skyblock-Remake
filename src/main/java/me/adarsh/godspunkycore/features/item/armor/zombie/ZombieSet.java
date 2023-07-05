package me.adarsh.godspunkycore.features.item.armor.zombie;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class ZombieSet implements ArmorSet {
    @Override
    public String getName() {
        return "Projectile Absorption";
    }

    @Override
    public String getDescription() {
        return "Heals the wearer for 10 ❤ HP per second for 5 seconds when hit by a projectile. Note: This set has no head item.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return null;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return ZombieChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return ZombieLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return ZombieBoots.class;
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