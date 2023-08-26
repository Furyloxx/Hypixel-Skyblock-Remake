package me.godspunky.skyblock.features.item.armor.blaze;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class BlazeSet implements ArmorSet {
    @Override
    public String getName() {
        return "Blazing Aura";
    }

    @Override
    public String getDescription() {
        return "Damages mobs in a "+ ChatColor.GREEN +"5"+ChatColor.GRAY+" block range for "+ ChatColor.GREEN +"3%"+ChatColor.GRAY+" of their max "+ChatColor.RED+"❤ Health"+ChatColor.GRAY+" per second. Also grants permanent Fire and Lava immunity.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return BlazeHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return BlazeChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return BlazeLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return BlazeBoots.class;
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


