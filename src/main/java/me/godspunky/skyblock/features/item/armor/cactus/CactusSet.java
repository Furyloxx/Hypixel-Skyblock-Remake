package me.godspunky.skyblock.features.item.armor.cactus;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CactusSet implements ArmorSet {
    @Override
    public String getName() {
        return "Deflect";
    }

    @Override
    public String getDescription() {
        return "Rebound"+ ChatColor.GREEN +" 33.0% of the "+ChatColor.RED+"damage+"+ChatColor.GRAY+" you take back at your enemy.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return CactusArmorHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return CactusArmorChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return CactusArmorLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return CactusArmorBoots.class;
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



