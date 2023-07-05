package me.adarsh.godspunkycore.features.item.armor.werewolf;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class WereWolfSet implements ArmorSet {
    @Override
    public String getName() {
        return "Regenerative Howl";
    }

    @Override
    public String getDescription() {
        return "Upon activating ⫽ Ferocity heal players within 25 blocks for 10% of your ❈ Defense and gain 50 ❈ Defense for 5s (stacking)";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return WerewolfHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return WerewolfChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return WerewolfLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return WerewolfBoots.class;
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

