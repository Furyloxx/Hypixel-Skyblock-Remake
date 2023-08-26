package me.godspunky.skyblock.features.item.armor.crystal;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CrystalSet implements ArmorSet {
    @Override
    public String getName() {
        return "Refraction ";
    }

    @Override
    public String getDescription() {
        return "The stats of this armor change from "+ ChatColor.GREEN +"0"+ChatColor.GRAY+" to"+ChatColor.GREEN+" 200%"+ChatColor.GRAY+" depending on the current light level.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return CrystalHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return CrystalChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return CrystalLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return CrystalBoots.class;
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


