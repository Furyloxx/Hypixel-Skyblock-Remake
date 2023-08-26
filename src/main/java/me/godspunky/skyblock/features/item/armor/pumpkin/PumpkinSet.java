package me.godspunky.skyblock.features.item.armor.pumpkin;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import me.godspunky.skyblock.features.item.armor.mushroom.MushroomBoots;
import me.godspunky.skyblock.features.item.armor.mushroom.MushroomChestplate;
import me.godspunky.skyblock.features.item.armor.mushroom.MushroomHelmet;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PumpkinSet implements ArmorSet {
    @Override
    public String getName() {
        return "Pumpkin Buff";
    }

    @Override
    public String getDescription() {
        return "Reduces all taken damage by"+ ChatColor.GREEN +" +10%"+ChatColor.GRAY+" and deal"+ChatColor.GREEN+" +10%"+ChatColor.GRAY+" damage";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return MushroomHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return MushroomChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return MushroomBoots.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return MushroomBoots.class;
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
