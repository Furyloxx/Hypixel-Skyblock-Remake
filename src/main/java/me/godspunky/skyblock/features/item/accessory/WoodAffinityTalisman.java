package me.godspunky.skyblock.features.item.accessory;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.region.Region;
import me.godspunky.skyblock.features.region.RegionType;
import me.godspunky.skyblock.user.PlayerUtils;
import me.godspunky.skyblock.features.item.*;
import org.bukkit.entity.Player;

public class WoodAffinityTalisman implements AccessoryStatistics, AccessoryFunction {
    @Override
    public String getURL() {
        return "ef119ade3b513e952bbbfc50e13f2d059f7b15099ba30671bbdc4647d3e7d18d";
    }

    @Override
    public String getDisplayName() {
        return "Wood Affinity Talisman";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ACCESSORY;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.ACCESSORY;
    }

    @Override
    public void update(SItem instance, Player player, int accessorySlot) {
        Region region = Region.getQuickRegionOfEntity(player);
        if (region == null) return;
        if (region.getType() != RegionType.FOREST && region.getType() != RegionType.GRAVEYARD && region.getType() != RegionType.WILDERNESS) return;
        PlayerUtils.addBoostStatistics(PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId()), accessorySlot, new PlayerBoostStatistics() {
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

            @Override
            public double getBaseSpeed() {
                return 0.10;
            }
        });
    }
}

