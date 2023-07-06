package me.adarsh.godspunkycore.features.item.armor.blaze;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class BlazeSet implements ArmorSet {
    @Override
    public String getName() {
        return "Blazing Aura";
    }

    @Override
    public String getDescription() {
        return "Damages mobs in a 5 block range for 3% of their max ❤ Health per second. Also grants permanent Fire and Lava immunity.";
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


