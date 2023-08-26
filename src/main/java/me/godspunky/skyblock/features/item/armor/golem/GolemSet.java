package me.godspunky.skyblock.features.item.armor.golem;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GolemSet implements ArmorSet {
    @Override
    public String getName() {
        return "Absorption ";
    }

    @Override
    public String getDescription() {
        return "Grants the wearer"+ ChatColor.GREEN +" Absorption III "+ChatColor.GRAY+"for "+ChatColor.GREEN+"20 seconds "+ChatColor.GRAY+"when they kill an enemy.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return GolemArmorHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return GolemArmorChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return GolemArmorLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return GolemArmorBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,20,3));
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



