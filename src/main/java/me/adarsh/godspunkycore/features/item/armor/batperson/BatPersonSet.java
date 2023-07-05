package me.adarsh.godspunkycore.features.item.armor.batperson;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class BatPersonSet implements ArmorSet {
    @Override
    public String getName() {
        return "Bat Power Activate!";
    }

    @Override
    public String getDescription() {
        return "Upgrades your Grappling Hook and turns you into a true vigilante! Grants an additional +5% chance to find rare Candy.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return BatpersonHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return BatpersonChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return BatpersonLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return BatpersonBoots.class;
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
