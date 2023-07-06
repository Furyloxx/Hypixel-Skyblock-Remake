package me.adarsh.godspunkycore.features.item.armor.farm;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import me.adarsh.godspunkycore.features.region.Region;
import me.adarsh.godspunkycore.features.region.RegionType;
import me.adarsh.godspunkycore.user.User;
import org.bukkit.entity.Player;

public class FarmSet implements ArmorSet {
    @Override
    public String getName() {
        return "Bonus Speed";
    }

    @Override
    public String getDescription() {
        return "Increases your ✦ Speed by +20 near Farming Minions or farming islands.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return FarmSuitHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return FarmSuitChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return FarmSuitLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return FarmSuitBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player) {
        User user = User.getUser(player.getUniqueId());
        Region region = Region.getRegionOfEntity(player);
        if (region != null && region.getType().equals(RegionType.FARM)){
            return new PlayerBoostStatistics() {
                @Override
                public double getBaseSpeed(){
                    return 0.2;
                }
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
        return null;
    }
}