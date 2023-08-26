package me.godspunky.skyblock.features.item.armor.growth;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GrowthSet implements ArmorSet {
    @Override
    public String getName() {
        return "Growth ";
    }

    @Override
    public String getDescription() {
        return "Heals the wearer for"+ ChatColor.RED +" 1.0% ❤ Health"+ChatColor.GRAY+" after killing a monster. It also increases max "+ChatColor.RED+"❤ Health"+ChatColor.GRAY+" bonus for each piece of armor by 1.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return GrowthHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return GrowthChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return GrowthLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return GrowthBoots.class;
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


