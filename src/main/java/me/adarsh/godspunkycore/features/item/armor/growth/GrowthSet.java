package me.adarsh.godspunkycore.features.item.armor.growth;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class GrowthSet implements ArmorSet {
    @Override
    public String getName() {
        return "Growth ";
    }

    @Override
    public String getDescription() {
        return "Heals the wearer for 1.0% ❤ Health after killing a monster. It also increases max ❤ Health bonus for each piece of armor by 1.";
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


