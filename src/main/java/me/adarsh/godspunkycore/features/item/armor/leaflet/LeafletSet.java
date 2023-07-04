package me.adarsh.godspunkycore.features.item.armor.leaflet;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import me.adarsh.godspunkycore.features.region.Region;
import me.adarsh.godspunkycore.features.region.RegionType;
import me.adarsh.godspunkycore.user.User;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LeafletSet implements ArmorSet {
    @Override
    public String getName() {
        return "Energy of the Forest";
    }

    @Override
    public String getDescription() {
        return "While in a forest zone, you regain 5.0 ❤ Health every second.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return LeafletHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return LeafletChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return LeafletLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return LeafletBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player) {
        User user = User.getUser(player.getUniqueId());
        Region region = Region.getRegionOfEntity(player);
        if (region != null && region.getType().equals(RegionType.FOREST)){
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,Integer.MAX_VALUE,1));
        }
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
