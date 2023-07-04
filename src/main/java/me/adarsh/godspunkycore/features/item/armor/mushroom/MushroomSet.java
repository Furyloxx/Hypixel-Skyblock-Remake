package me.adarsh.godspunkycore.features.item.armor.mushroom;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MushroomSet implements ArmorSet {
    @Override
    public String getName() {
        return "Night Affinity";
    }

    @Override
    public String getDescription() {
        return "Grants the wearer with permanent Night Vision while worn, and during the night, the stats of the armor pieces are tripled.";
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
        return MushroomLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return MushroomBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1));
        return new PlayerBoostStatistics() {
            @Override
            public String getDisplayName() {
                return null;
            }

            @Override
            public Rarity getRarity() {
                return Rarity.UNCOMMON;
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