package me.adarsh.godspunkycore.features.item.armor.cheaptuxedo;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class CheapTuxedoSet implements ArmorSet {
    @Override
    public String getName() {
        return "Dashing";
    }

    @Override
    public String getDescription() {
        return "Max health set to 75❤. Deals +50% damage!";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return null;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return CheapTuxedoChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return CheapTuxedoLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return CheapTuxedoBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player) {
        return new PlayerBoostStatistics() {
            // TODO: add ability
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
