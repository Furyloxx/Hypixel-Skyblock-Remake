package me.godspunky.skyblock.features.item.armor.packarmor;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class PackSet implements ArmorSet {
    @Override
    public String getName() {
        return "Armor of the Pack";
    }

    @Override
    public String getDescription() {
        return "Gain +35 ❁ Strength and +80 ❈ Defense for each Armor of the Pack wearers within 30 blocks. Max of 3 players.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return PackHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return PackChestpate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return Packleggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return PackBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player) {
        return new PlayerBoostStatistics() {
                @Override
                public double getBaseStrength(){return 35;}

                @Override
                public double getBaseDefense(){return 80;}

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