package me.adarsh.godspunkycore.features.item.armor.angler;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import me.adarsh.godspunkycore.user.User;
import org.bukkit.entity.Player;

public class AnglerSet implements ArmorSet {
    @Override
    public String getName() {
        return "Deepness Within";
    }

    @Override
    public String getDescription() {
        return "Gain +10 ❤ HP per Fishing Level.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return AnglerHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return AnglerChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return AnglerBoots.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return AnglerBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player) {
        User user = User.getUser(player.getUniqueId());
        // TODO: (get fishing lvl)*10 hearts
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