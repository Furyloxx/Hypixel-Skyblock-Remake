package me.adarsh.godspunkycore.features.item.armor.crystal;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class CrystalSet implements ArmorSet {
    @Override
    public String getName() {
        return "Refraction ";
    }

    @Override
    public String getDescription() {
        return "The stats of this armor change from 0 to 200% depending on the current light level.";
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


