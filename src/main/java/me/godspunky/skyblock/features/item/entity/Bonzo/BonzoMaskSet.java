package me.godspunky.skyblock.features.item.entity.Bonzo;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class BonzoMaskSet implements ArmorSet {
    @Override
    public String getName() {
        return "Clownin' Around";
    }

    @Override
    public String getDescription() {
        return "Instead of dying, gain damage immunity and X ❁ Strength for 3s and fully replenish your health. The cooldown and Strength bonus you receive improve based on your Dungeoneering Skill level. This ability only works while in The Catacombs";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return BonzoMask.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return null;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return null;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return null;
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


