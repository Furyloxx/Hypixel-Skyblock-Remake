package me.godspunky.skyblock.features.item.armor.lapis;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class LapisArmorSet implements ArmorSet {
    @Override
    public String getName() {
        return "Health";
    }

    @Override
    public String getDescription() {
        return "Increases the wearer's maximum"+ ChatColor.RED +"❤ Health "+ChatColor.GRAY+"by"+ChatColor.GREEN+" 60.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return LapisArmorHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return LapisArmorChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return LapisArmorLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return LapisArmorBoots.class;
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
            public double getBaseHealth() {
                return 60;
            }
        };
    }
}
