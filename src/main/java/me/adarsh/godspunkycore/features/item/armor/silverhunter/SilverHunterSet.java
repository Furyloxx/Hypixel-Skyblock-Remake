package me.adarsh.godspunkycore.features.item.armor.silverhunter;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class SilverHunterSet implements ArmorSet {
    @Override
    public String getName() {
        return "Peace Treaty";
    }

    @Override
    public String getDescription() {
        return "Gain immunity from Sea Creatures because they are immune to you and you can no longer catch them.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return SilverHunterHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return SilverHunterChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return SilverHunterLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return SilverHunterBoots.class;
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
            public String getLore() {
                return null;
            }

            @Override
            public GenericItemType getType() {
                return GenericItemType.ARMOR;
            }
        };
    }
}