package me.adarsh.godspunkycore.features.item.armor.pumpkin;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import me.adarsh.godspunkycore.features.item.armor.mushroom.MushroomBoots;
import me.adarsh.godspunkycore.features.item.armor.mushroom.MushroomChestplate;
import me.adarsh.godspunkycore.features.item.armor.mushroom.MushroomHelmet;
import org.bukkit.entity.Player;

public class PumpkinSet implements ArmorSet {
    @Override
    public String getName() {
        return "Pumpkin Buff";
    }

    @Override
    public String getDescription() {
        return "Reduces all taken damage by +10% and deal +10% damage";
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
        return MushroomBoots.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return MushroomBoots.class;
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
